package br.com.projects.hotelreservationservice.service;

import java.util.List;

import br.com.projects.hotelreservationservice.entity.Address;


public interface AddressService {
    public List<Address> findAll();

	public Address findById(Long theId);

	public Address save(Address theAddress);

	public Address update(Address theAddress);

	public void deleteById(Long theId);

}
