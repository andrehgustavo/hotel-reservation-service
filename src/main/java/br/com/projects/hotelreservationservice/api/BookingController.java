package br.com.projects.hotelreservationservice.api;

import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.hotelreservationservice.entity.Booking;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.service.BookingService;

/**
 * Class to handle all Booking related requests
 * 
 * @author André Gustavo
 */
@RestController
@RequestMapping("/")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

	/**
	 * Request a List of all system active bookings
	 * @return
	 */
    @GetMapping("/bookings")
	public ResponseEntity<List<Booking>> findAll() {
		return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
	}

	/**
	 * Request a single system Booking
	 * @param bookingId the Booking id you want to retrieve.
	 * @return
	 */
	@GetMapping("/bookings/{bookingId}")
	public ResponseEntity<?> getBooking(@PathVariable Long bookingId) {
		try {
			Booking theBooking = bookingService.findById(bookingId);
			return new ResponseEntity<>(theBooking, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}		
	}

	/**
	 * Request to save a booking in the system
	 * @param theBooking the Booking you want to save.
	 * @return
	 */
	@PostMapping("/bookings")
	public ResponseEntity<?> createBooking(@RequestBody Booking theBooking) {
		try {
			Booking savedBooking = bookingService.save(theBooking);
			return new ResponseEntity<>(savedBooking.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}

	/**
	 * Request to update a booking in the system
	 * @param theBooking the Booking you want to update.
	 * @return
	 */
	@PutMapping("/bookings")
	public ResponseEntity<?> updateBooking(@RequestBody Booking theBooking) {
		try {
			bookingService.update(theBooking);
			return new ResponseEntity<>(theBooking, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}

	/**
	 * Request to delete a booking in the system
	 * @param bookingId the Booking id you want to delete.
	 * @return
	 */
	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<?> deleteBooking(@PathVariable Long bookingId) {
		try {
			bookingService.deleteById(bookingId);
			return new ResponseEntity<>("Booking com id " + bookingId + " deletado com sucesso.", HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}
	}

	@PostMapping("/bookings/schedule")
	public ResponseEntity<?> scheduleBooking(@RequestParam String name, 
											@RequestParam String phoneNumber,
											@RequestParam String email,
											@RequestParam List<String> period,
											@RequestParam String hotel,
											@RequestParam String bookingType,
											@RequestParam String remarks) throws ParseException {
		try {
			JsonNode bookingNumber = bookingService.scheduleBooking(name, phoneNumber, email, period, hotel, bookingType, remarks);
			return new ResponseEntity<>(bookingNumber, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}		
	}

	@GetMapping("/bookings/consult")
	public ResponseEntity<?> consultBooking(@RequestParam Long bookingNumber, 
											@RequestParam String hotel,
											@RequestParam String bookingType,
											@RequestParam List<String> period) throws ParseException {
		try {
			JsonNode booking = bookingService.consultBooking(bookingNumber, period, hotel, bookingType);
			return new ResponseEntity<>(booking, HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return ResponseEntity.accepted().body(e.toString());
		}		
	}

	/**
	 * Request to cancel a booking in the system
	 * @param theBooking the Booking you want to update.
	 * @return
	 */
	@PutMapping("/bookings/cancel")
	public ResponseEntity<?> cancelBooking(@RequestParam Long bookingNumber) {
		try {
			Booking booking = bookingService.cancelBooking(bookingNumber);
			return new ResponseEntity<>("Reserva cancelada com Sucesso", HttpStatus.OK);
		}catch (ErrorRegisterNotFoundInDataBase e) {
			return new ResponseEntity<>("Não foi possível cancelar essa reserva.", HttpStatus.FAILED_DEPENDENCY);
		}
	}
}
