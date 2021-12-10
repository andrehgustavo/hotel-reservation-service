package br.com.projects.hotelreservationservice.controllers;

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

import br.com.projects.hotelreservationservice.entity.Rate;
import br.com.projects.hotelreservationservice.service.RateService;

/**
 * Class to handle all Rate related requests
 * 
 * @author André Gustavo
 */
@RestController
@RequestMapping("/")
public class RateController {
    
    @Autowired
    private RateService rateService;

    @GetMapping("/rates")
	public ResponseEntity<List<Rate>> findAll() {
		return new ResponseEntity<>(rateService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/rates/{rateId}")
	public ResponseEntity<?> getRate(@PathVariable Long rateId) {
		Rate theRate = rateService.findById(rateId);
		return new ResponseEntity<>(theRate, HttpStatus.OK);		
	}

	@PostMapping("/rates")
	public ResponseEntity<?> createRate(@RequestBody Rate theRate) {
		Rate savedRate = rateService.save(theRate);
		return new ResponseEntity<>(savedRate.getId(), HttpStatus.CREATED);
	}

	@PutMapping("/rates")
	public ResponseEntity<?> updateRate(@RequestBody Rate theRate) {
		rateService.update(theRate);
		return new ResponseEntity<>(theRate, HttpStatus.OK);
	}

	@DeleteMapping("/rates/{rateId}")
	public ResponseEntity<?> deleteRate(@PathVariable Long rateId) {
		rateService.deleteById(rateId);
		return new ResponseEntity<>("Taxa com id " + rateId + " deletado com sucesso.", HttpStatus.OK);
	}
}
