package br.com.projects.hotelreservationservice.service;

import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.projects.hotelreservationservice.entity.Booking;
import br.com.projects.hotelreservationservice.entity.ResponseBooking;

/**
 * Booking Service.
 * 
 * @author André Gustavo
 */

public interface BookingService {

	/** Static number representing status CANCELLED */
	public static final int CANCELLED = 0;
	
	/** Static number representing status CONFIRMED */
	public static final int CONFIRMED = 1;

    public List<Booking> findAll();

	public Booking findById(Long theId);

	public Booking save(Booking theBooking);

	public Booking update(Booking theBooking);

	public void deleteById(Long theId);

	/**
	 * Method to schedule a booking.
	 * @param name booking's customer name
	 * @param phoneNumber booking's customer phone number
	 * @param email booking's customer email
	 * @param period booking's customer period
	 * @param hotel booking's customer hotel
	 * @param bookingType booking's customer type (Regular or Reward)
	 * @param remarks
	 * @return
	 * @throws ParseException
	 */
    public JsonNode scheduleBooking(String name, String phoneNumber, String email, List<String> period,
            String hotel, String bookingType, String remarks) throws ParseException;

	public ResponseBooking consultBooking(Long bookingNumber, List<String> period, String hotel, String bookingType);

	public JsonNode cancelBooking(Long bookingNumber);

}
