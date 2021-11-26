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

import br.com.projects.hotelreservationservice.entity.Address;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.service.AddressService;

@RestController
@RequestMapping("/")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
	public ResponseEntity<List<Address>> findAll() {
		return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/addresses/{addressId}")
	public ResponseEntity<?> getAddress(@PathVariable Long addressId) {
		try {
			Address theAddress = addressService.findById(addressId);
			return new ResponseEntity<>(theAddress, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}		
	}

	@PostMapping("/addresses")
	public ResponseEntity<?> createAddress(@RequestBody Address theAddress) {
		try {
			Address savedAddress = addressService.save(theAddress);
			return new ResponseEntity<>(savedAddress.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}

	@PutMapping("/addresses")
	public ResponseEntity<?> updateAddress(@RequestBody Address theAddress) {
		try {
			addressService.update(theAddress);
			return new ResponseEntity<>(theAddress, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}

	@DeleteMapping("/addresses/{addressId}")
	public ResponseEntity<?> deleteAddress(@PathVariable Long addressId) {
		try {
			addressService.deleteById(addressId);
			return new ResponseEntity<>("Address com id " + addressId + " deletado com sucesso.", HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}
}
