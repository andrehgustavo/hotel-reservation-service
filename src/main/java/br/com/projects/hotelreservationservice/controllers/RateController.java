package br.com.projects.hotelreservationservice.controllers;

import java.util.List;

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

import br.com.projects.hotelreservationservice.entity.Rate;
import br.com.projects.hotelreservationservice.service.RateService;
import br.com.projects.hotelreservationservice.utils.Utils;
import io.swagger.annotations.ApiOperation;

/**
 * Class to handle all Rate related requests
 * 
 * @author André Gustavo
 */
@RestController
@Validated
@RequestMapping("/")
public class RateController {
    
    @Autowired
    private RateService rateService;

	/**
	 * Request a List of all system rates
	 * @return
	 */
	@ApiOperation(value = "Request a List of all system rates")
    @GetMapping(value = "/rates", produces="application/json")
	public ResponseEntity<List<Rate>> findAll() {
		return new ResponseEntity<>(rateService.findAll(), HttpStatus.OK);
	}

	/**
	 * Request a single system Rate
	 * @param rateId the Rate id you want to retrieve.
	 * @return
	 */
	@ApiOperation(value = "Request a single system Rate")
	@GetMapping(value = "/rates/{rateId}", produces="application/json")
	public ResponseEntity<?> getRate(@PathVariable Long rateId) {
		Rate theRate = rateService.findById(rateId);
		return new ResponseEntity<>(theRate, HttpStatus.OK);		
	}

	/**
	 * Request to save a rate in the system
	 * @param theRate the Rate you want to save.
	 * @return
	 */
	@ApiOperation(value = "Request to save a rate in the system")
	@PostMapping(value = "/rates", produces="application/json", consumes="application/json")
	public ResponseEntity<?> createRate(@RequestBody Rate theRate) {
		Rate savedRate = rateService.save(theRate);
		return new ResponseEntity<>(savedRate.getId(), HttpStatus.CREATED);
	}

	/**
	 * Request to update a rate in the system
	 * @param theRate the Rate you want to update.
	 * @return
	 */
	@ApiOperation(value = "Request to update a rate in the system")
	@PutMapping(value = "/rates", produces="application/json", consumes="application/json")
	public ResponseEntity<?> updateRate(@RequestBody Rate theRate) {
		rateService.update(theRate);
		return new ResponseEntity<>(theRate, HttpStatus.OK);
	}

	/**
	 * Request to delete a rate in the system
	 * @param rateId the Rate id you want to delete.
	 * @return
	 */
	@ApiOperation(value = "Request to delete a rate in the system")
	@DeleteMapping(value = "/rates/{rateId}", produces="application/json")
	public ResponseEntity<?> deleteRate(@PathVariable Long rateId) {
		rateService.deleteById(rateId);
		return new ResponseEntity<>(Utils.convertMsgToJson("message","Taxa com id " + rateId + " deletado com sucesso."), HttpStatus.OK);
	}
}
