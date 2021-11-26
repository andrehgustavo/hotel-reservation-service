package br.com.projects.hotelreservationservice.service;

import java.util.List;

import br.com.projects.hotelreservationservice.entity.Rate;


public interface RateService {
    public List<Rate> findAll();

	public Rate findById(Long theId);

	public Rate save(Rate theRate);

	public Rate update(Rate theRate);

	public void deleteById(Long theId);

}
