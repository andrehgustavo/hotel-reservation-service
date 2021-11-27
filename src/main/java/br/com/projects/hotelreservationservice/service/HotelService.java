package br.com.projects.hotelreservationservice.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.projects.hotelreservationservice.entity.Hotel;

/**
 * Service's Hotel interface
 */
public interface HotelService {
    public List<Hotel> findAll();

	public Hotel findById(Long theId);

	public Hotel save(Hotel theHotel);

	public Hotel update(Hotel theHotel);

	public void deleteById(Long theId);

	/**
	 * Method to retrieve the cheapest hotel from a date list.
	 * @param type type of customer
	 * @param dates a list of possible hotel booking dates.
	 * @return the Cheapest hotel in JSON format.
	 */
    public JsonNode getCheapest(String type, List<String> dates);

}
