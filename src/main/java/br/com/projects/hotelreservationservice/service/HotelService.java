package br.com.projects.hotelreservationservice.service;

import java.util.List;

import br.com.projects.hotelreservationservice.entity.Hotel;

public interface HotelService {
    public List<Hotel> findAll();

	public Hotel findById(Long theId);

	public Hotel save(Hotel theHotel);

	public Hotel update(Hotel theHotel);

	public void deleteById(Long theId);

}
