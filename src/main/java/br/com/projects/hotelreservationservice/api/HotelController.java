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

import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.service.HotelService;

@RestController
@RequestMapping("/api")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> findAll() {
		return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<?> getHotel(@PathVariable Long hotelId) {
		try {
			Hotel theHotel = hotelService.findById(hotelId);
			return new ResponseEntity<>(theHotel, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}		
	}

	@PostMapping("/hotels")
	public ResponseEntity<?> createHotel(@RequestBody Hotel theHotel) {
		try {
			Hotel savedHotel = hotelService.save(theHotel);
			return new ResponseEntity<>(savedHotel.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}

	@PutMapping("/hotels")
	public ResponseEntity<?> updateHotel(@RequestBody Hotel theHotel) {
		try {
			hotelService.update(theHotel);
			return new ResponseEntity<>(theHotel, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}

	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId) {
		try {
			hotelService.deleteById(hotelId);
			return new ResponseEntity<>("Médico com id " + hotelId + " deletado com sucesso.", HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}
}
