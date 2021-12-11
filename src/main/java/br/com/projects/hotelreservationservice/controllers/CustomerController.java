package br.com.projects.hotelreservationservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.hotelreservationservice.entity.Customer;
import br.com.projects.hotelreservationservice.service.CustomerService;
import io.swagger.annotations.ApiOperation;

/**
 * Class to handle all Customer related requests
 * 
 * @author André Gustavo
 */
@RestController
@Validated
@RequestMapping("/")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

	@ApiOperation(value = "Request a List of all system customers")
    @GetMapping(value = "/customers", produces="application/json")
	public ResponseEntity<List<Customer>> findAll() {
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Request a single system Customer")
	@GetMapping(value = "/customers/{customerId}", produces="application/json")
	public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
		Customer theCustomer = customerService.findById(customerId);
		return new ResponseEntity<>(theCustomer, HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Request to save a customer in the system")
	@PostMapping(value = "/customers", produces="application/json", consumes="application/json")
	public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer theCustomer) {
		Customer savedCustomer = customerService.save(theCustomer);
		return new ResponseEntity<>(savedCustomer.getId(), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Request to update a customer in the system")
	@PutMapping(value = "/customers", produces="application/json", consumes="application/json")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer theCustomer) {
		customerService.update(theCustomer);
		return new ResponseEntity<>(theCustomer, HttpStatus.OK);
	}

	@ApiOperation(value = "Request to delete a customer in the system")
	@DeleteMapping(value = "/customers/{customerId}",  produces="application/json")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteById(customerId);
		return new ResponseEntity<>("Cliente com id " + customerId + " deletado com sucesso.", HttpStatus.OK);
	}
}
