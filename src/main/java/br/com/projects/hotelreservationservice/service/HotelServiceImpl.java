package br.com.projects.hotelreservationservice.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.entity.LoyaltyProgram;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.repository.HotelRepository;

/**
 * Service for Hotel
 */
@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findById(Long theId) {		
		Optional<Hotel> result = hotelRepository.findById(theId);

		if(result.isPresent()) {
			return result.get();
		}else {
			//Hotel não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Hotel com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Hotel save(Hotel theHotel) {
		// Caso o usuário envie um ID do frontend pelo JSON,
		// esse resguardo seta ele como 0, para o sistema forçar a entender como um novo
		// ao invés de fazer o update - Boas práticas!
		theHotel.setId(0L);
		return hotelRepository.save(theHotel);		
	}

	@Override
	public void deleteById(Long theId) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(theId);

		if(optionalHotel.isPresent()){
			hotelRepository.deleteById(theId);
		}else {		
			throw new ErrorRegisterNotFoundInDataBase("Hotel com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Hotel update(Hotel theHotel) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(theHotel.getId());

		if(optionalHotel.isPresent()){
			return hotelRepository.save(theHotel);
		}else{
			throw new ErrorRegisterNotFoundInDataBase("Hotel com Id " + theHotel.getId() + " não existe no banco de dados.");
		}
		
	}

	@Override
	public JsonNode getCheapest(String type, List<String> dates) {
		LoyaltyProgram loyaltyProgram = LoyaltyProgram.valueOf(type.toUpperCase());
		int[] numberOfDays = getNumberOfDays(dates);
		int weekDays = numberOfDays[0];
		int weekendsDays = numberOfDays[1];
		List<Hotel> hotels = findAll();
		double cheapest = 10000.0;
		double total = 0.0;
		Hotel theHotel = new Hotel();
		for (Hotel hotel : hotels) {
			total = hotel.getTableRate().get(loyaltyProgram.name()).getPricePerDays().get("WEEKDAYS") * weekDays +
					hotel.getTableRate().get(loyaltyProgram.name()).getPricePerDays().get("WEEKENDDAYS") * weekendsDays;
			if(total < cheapest){
				cheapest = total;
				theHotel = hotel;
			}else if (total == cheapest){
				theHotel = theHotel.getClassification() > hotel.getClassification() ? theHotel : hotel;
			}
		} 
		return convertObjectToJson(theHotel);
	}

	/**
	 * Mount the cheapest hotel in JSON format.
	 * @param theHotel a Hotel that will be converted.
	 * @return a Json with cheapest hotel.
	 */
	private JsonNode convertObjectToJson(Hotel theHotel) {
		String json_str = "{\"cheapest\":\"" + theHotel.getName() + "\"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(json_str);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	return node;
	}

	/**
	 * Method to calculate the number of weekdays and weekends using regular expression.
	 * @param dates a String day list containing day abbreviations
	 * @return an array with the number of weekdays and the number of days in the weekend, respectively
	 */
	private int[] getNumberOfDays(List<String> dates) {
		Pattern pattern = Pattern.compile("\\b((mon|tues|wed(nes)?|thur(s)?|fri)(day)?)\\b");
        Matcher matcher;
		int weekdays = 0;
		int weekends = 0;
		for (String date : dates) {
			matcher = pattern.matcher(date);
			if(matcher.find()){
				++weekdays;
			}else{
				++weekends;
			} 
		}
		int[] answer = {weekdays, weekends};
		return answer;
	}


    
}
