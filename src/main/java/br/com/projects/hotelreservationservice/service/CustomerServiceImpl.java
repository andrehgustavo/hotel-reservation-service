package br.com.projects.hotelreservationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.hotelreservationservice.entity.Customer;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long theId) {		
		Optional<Customer> result = customerRepository.findById(theId);

		if(result.isPresent()) {
			return result.get();
		}else {
			//Customer não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Cliente com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Customer save(Customer theCustomer) {

		theCustomer.setId(0L);
		return customerRepository.save(theCustomer);		
	}

	@Override
	public void deleteById(Long theId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(theId);

		if(optionalCustomer.isPresent()){
			customerRepository.deleteById(theId);
		}else {		
			throw new ErrorRegisterNotFoundInDataBase("Cliente com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Customer update(Customer theCustomer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(theCustomer.getId());

		if(optionalCustomer.isPresent()){
			return customerRepository.save(theCustomer);
		}else{
			throw new ErrorRegisterNotFoundInDataBase("Cliente com Id " + theCustomer.getId() + " não existe no banco de dados.");
		}
		
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);		
	}
    
}
