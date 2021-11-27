package br.com.projects.hotelreservationservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.hotelreservationservice.entity.Customer;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.service.CustomerService;

/**
 * Class to handle all Customer related requests
 * 
 * @author André Gustavo
 */
@RestController
@RequestMapping("/")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
	public ResponseEntity<List<Customer>> findAll() {
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
		try {
			Customer theCustomer = customerService.findById(customerId);
			return new ResponseEntity<>(theCustomer, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}		
	}

	@PostMapping("/customers")
	public ResponseEntity<?> createCustomer(@RequestBody Customer theCustomer) {
		try {
			Customer savedCustomer = customerService.save(theCustomer);
			return new ResponseEntity<>(savedCustomer.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}

	@PutMapping("/customers")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer theCustomer) {
		try {
			customerService.update(theCustomer);
			return new ResponseEntity<>(theCustomer, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
		try {
			customerService.deleteById(customerId);
			return new ResponseEntity<>("Customer com id " + customerId + " deletado com sucesso.", HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}
}
