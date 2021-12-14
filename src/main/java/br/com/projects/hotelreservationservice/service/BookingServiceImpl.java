package br.com.projects.hotelreservationservice.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.hotelreservationservice.entity.Booking;
import br.com.projects.hotelreservationservice.entity.Customer;
import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.entity.LoyaltyProgram;
import br.com.projects.hotelreservationservice.entity.ResponseBooking;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.repository.BookingRepository;
import br.com.projects.hotelreservationservice.utils.Utils;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;
	@Autowired
    private HotelService hotelService;
	@Autowired
    private CustomerService customerService;
	@Autowired
	private EmailService emailService;

    @Override
	public List<Booking> findAll() {
		return bookingRepository.findAllbyActive();
	}

	@Override
	public Booking findById(Long theId) {		
		Optional<Booking> result = bookingRepository.findById(theId);

		if(result.isPresent()) {
			return result.get();
		}else {
			//Booking não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Reserva com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Booking save(Booking theBooking) {
		theBooking.setId(0L);

		//Init a new Booking
		Long bookingNumber = getValidBookingNumber();
		int days[] = Booking.getWeekDays(theBooking.getCheckin(), theBooking.getCheckout());
		double price = hotelService.calculateTotalPrice(theBooking.getType(), days[0], days[1], theBooking.getHotel());
		theBooking.setNumber(bookingNumber);
		theBooking.setPrice(price);
		theBooking.setActive(true);
		theBooking.setBookingDate(new Timestamp(System.currentTimeMillis()));

		return bookingRepository.save(theBooking);	
	}

	@Override
	public void deleteById(Long theId) {
		Optional<Booking> optionalBooking = bookingRepository.findById(theId);

		if(optionalBooking.isPresent()){
			bookingRepository.deleteById(theId);
		}else {		
			throw new ErrorRegisterNotFoundInDataBase("Reserva com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Booking update(Booking theBooking) {
		Optional<Booking> optionalBooking = bookingRepository.findById(theBooking.getId());

		if(optionalBooking.isPresent()){
			return bookingRepository.save(theBooking);
		}else{
			throw new ErrorRegisterNotFoundInDataBase("Reserva com Id " + theBooking.getId() + " não existe no banco de dados.");
		}
		
	}

	@Override
	public JsonNode scheduleBooking(String name, String phoneNumber, String email, List<String> period, String hotelName, String bookingType, String remarks) throws ParseException{
		LoyaltyProgram loyaltyProgram = LoyaltyProgram.valueOf(bookingType.toUpperCase());
		Customer customer = customerService.findByEmail(email);	
		if(customer == null){
			customer = new Customer(name, phoneNumber, email, loyaltyProgram);
		}
		Hotel hotel = hotelService.findByName(hotelName);
		if(hotel == null){
			hotel = new Hotel(hotelName);
		}
		java.sql.Date[] checkinCheckout = getCheckinCheckout(period);
		java.sql.Date checkin = checkinCheckout[0];
		java.sql.Date checkout = checkinCheckout[1];
		
		Long bookingNumber = getValidBookingNumber();
		int days[] = Booking.getWeekDays(checkin, checkout);
		double price = hotelService.calculateTotalPrice(loyaltyProgram, days[0], days[1], hotel);
		Booking booking = new Booking(customer, hotel, checkin, checkout, loyaltyProgram, remarks, bookingNumber, price);
		booking = save(booking);
		try {
			emailService.sendInformationMail(CONFIRMED, booking);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Utils.convertMsgToJson("bookingNumber", Long.toString(bookingNumber));
	}


	@Override
	public ResponseBooking consultBooking(Long bookingNumber, List<String> period, String hotel, String bookingType) {
		Optional<Booking> result = bookingRepository.findByNumber(bookingNumber);

		if(result.isPresent()) {
			ResponseBooking response = new ResponseBooking(result.get());
			return response;
		}else {
			//Booking não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Reserva com número " + bookingNumber + " não existe no banco de dados.");
		}
	}

	@Override
	public JsonNode cancelBooking(Long bookingNumber) {
		Optional<Booking> result = bookingRepository.findByNumber(bookingNumber);

		if(result.isPresent()) {
			Booking booking = result.get();
			booking.setActive(false);
			emailService.sendInformationMail(CANCELLED, booking);	
			bookingRepository.save(booking);
			return Utils.convertMsgToJson("message", "Reserva " + bookingNumber + " cancelada com sucesso.");
		}else {
			//Booking não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Reserva com número " + bookingNumber + " não existe no banco de dados.");
		}
	}

	/**
	 * Method to retrieve checkin and checkout of a list
	 * @param period - list of string dates.
	 * @return an array with two dates
	 * @throws ParseException
	 */
	private java.sql.Date[] getCheckinCheckout(List<String> period) throws ParseException {	
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date[] result = new java.sql.Date[2];
		DateTime data1 = new DateTime(fmt.parse(period.get(0)).getTime());

		if(period.size() == 1){
			result[0]=new java.sql.Date( data1.getMillis());
			data1.plusDays(1);
			result[1]=new java.sql.Date( data1.getMillis());
			return result;
		}else{
			DateTime data2 = new DateTime(fmt.parse(period.get(period.size()-1)).getTime());        
			for (String date : period) {
				DateTime tempData = new DateTime(fmt.parse(date).getTime());
				if(data1.isAfter(tempData.getMillis())){
					data1 = tempData;
				}
				if(data2.isBefore(tempData.getMillis())){
					data2 = tempData;
				}
			}
			result[0]=new java.sql.Date( data1.getMillis());
			result[1]=new java.sql.Date( data2.getMillis());
			return result;
		}
	}

	/**
	 * Method to create a exclusive booking number 
	 * @return
	 */
	private Long getValidBookingNumber() {
		Long bookingNumber = (Long) new Date().getTime();
		while(bookingRepository.existsByNumber(bookingNumber)){
			++bookingNumber;
		}
		return bookingNumber;
	}
}
