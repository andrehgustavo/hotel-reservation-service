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

import br.com.projects.hotelreservationservice.entity.Address;
import br.com.projects.hotelreservationservice.service.AddressService;
import br.com.projects.hotelreservationservice.utils.Utils;
import io.swagger.annotations.ApiOperation;

/**
 * Class to handle all Address related requests
 * 
 * @author André Gustavo
 */
@RestController
@Validated
@RequestMapping("/")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

	/**
	 * Request a List of all system addresses
	 * @return
	 */
	@ApiOperation(value = "Request a List of all system addresses")
    @GetMapping(value = "/addresses", produces="application/json")
	public ResponseEntity<List<Address>> findAll() {
		return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
	}

	/**
	 * Request a single system address
	 * @param addressId the address id you want to retrieve.
	 * @return
	 */
	@ApiOperation(value = "Request a single system address")
	@GetMapping(value = "/addresses/{addressId}", produces="application/json")
	public ResponseEntity<?> getAddress(@PathVariable Long addressId) {
		Address theAddress = addressService.findById(addressId);
		return new ResponseEntity<>(theAddress, HttpStatus.OK);	
	}

	/**
	 * Request to save an address in the system
	 * @param theAddress the address you want to save.
	 * @return
	 */
	@ApiOperation(value = "Request to save an address in the system")
	@PostMapping(value = "/addresses", produces="application/json", consumes="application/json")
	public ResponseEntity<?> createAddress(@RequestBody @Valid Address theAddress) {
		Address savedAddress = addressService.save(theAddress);
		return new ResponseEntity<>(savedAddress.getId(), HttpStatus.CREATED);
	}

	/**
	 * Request to update an address in the system
	 * @param theAddress the address you want to update.
	 * @return
	 */
	@ApiOperation(value = "Request to update an address in the system")
	@PutMapping(value = "/addresses", produces="application/json", consumes="application/json")
	public ResponseEntity<?> updateAddress(@RequestBody Address theAddress) {
		addressService.update(theAddress);
		return new ResponseEntity<>(theAddress, HttpStatus.OK);
	}

	/**
	 * Request to delete an address in the system
	 * @param addressId the address id you want to delete.
	 * @return
	 */
	@ApiOperation(value = "Request to delete an address in the system")
	@DeleteMapping(value = "/addresses/{addressId}",  produces="application/json")
	public ResponseEntity<?> deleteAddress(@PathVariable Long addressId) {
		addressService.deleteById(addressId);
		return new ResponseEntity<>(Utils.convertMsgToJson("message", "Endereço com id " + addressId + " deletado com sucesso."), HttpStatus.OK);
	}
}
