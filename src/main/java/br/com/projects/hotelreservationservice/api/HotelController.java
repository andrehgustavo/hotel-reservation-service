package br.com.projects.hotelreservationservice.api;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.JsonNode;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.service.HotelService;

/**
 * Class to handle all Hotel related requests
 * 
 * @author André Gustavo
 */
@RestController
@Validated
@RequestMapping("/")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

	/**
	 * Request a List of all system hotels
	 * @return
	 */
    @GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> findAll() {
		return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
	}

	/**
	 * Request a single system hotel
	 * @param hotelId The hotel id id you want to retrieve.
	 * @return
	 */
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<?> getHotel(@PathVariable Long hotelId) {
		Hotel theHotel = hotelService.findById(hotelId);
		return new ResponseEntity<>(theHotel, HttpStatus.OK);
				
	}

	/**
	 * Request to save a hotel in the system
	 * @param theHotel the hotel you want to save.
	 * @return
	 */
	@PostMapping("/hotels")
	public ResponseEntity<?> createHotel(@RequestBody Hotel theHotel) {
		Hotel savedHotel = hotelService.save(theHotel);
		return new ResponseEntity<>(savedHotel.getId(), HttpStatus.CREATED);
	}

	/**
	 * Request to update a hotel in the system
	 * @param theHotel the hotel you want to update.
	 * @return
	 */
	@PutMapping("/hotels")
	public ResponseEntity<?> updateHotel(@RequestBody Hotel theHotel) {
		hotelService.update(theHotel);
		return new ResponseEntity<>(theHotel, HttpStatus.OK);
	}

	/**
	 * Request to delete a hotel in the system
	 * @param hotelId the hotel id you want to delete.
	 * @return
	 */
	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId) {
		hotelService.deleteById(hotelId);
		return new ResponseEntity<>("Hotel com id " + hotelId + " deletado com sucesso.", HttpStatus.OK);
	}

	@GetMapping("/cheapest")
	public ResponseEntity<?> getCheapest(@RequestParam @NotBlank String type, @RequestParam @NotEmpty List<String> dates) {
			JsonNode theCheapest = hotelService.getCheapest(type, dates);
			return new ResponseEntity<>(theCheapest, HttpStatus.OK);
	}			
}
