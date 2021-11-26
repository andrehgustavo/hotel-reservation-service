package br.com.projects.hotelreservationservice.service;

import java.util.List;

import br.com.projects.hotelreservationservice.entity.Customer;

public interface CustomerService {
    public List<Customer> findAll();

	public Customer findById(Long theId);

	public Customer save(Customer theCustomer);

	public Customer update(Customer theCustomer);

	public void deleteById(Long theId);

}
