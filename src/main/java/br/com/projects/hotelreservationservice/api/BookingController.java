package br.com.projects.hotelreservationservice.api;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

import br.com.projects.hotelreservationservice.Utils.Utils;
import br.com.projects.hotelreservationservice.entity.Booking;
import br.com.projects.hotelreservationservice.entity.ResponseBooking;
import br.com.projects.hotelreservationservice.service.BookingService;

/**
 * Class to handle all Booking related requests
 * 
 * @author André Gustavo
 */
@RestController
@Validated
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
		Booking theBooking = bookingService.findById(bookingId);
		return new ResponseEntity<>(theBooking, HttpStatus.OK);
	}

	/**
	 * Request to save a booking in the system
	 * @param theBooking the Booking you want to save.
	 * @return
	 */
	@PostMapping("/bookings")
	public ResponseEntity<?> createBooking(@RequestBody @Valid Booking theBooking) {
		Booking savedBooking = bookingService.save(theBooking);
		return new ResponseEntity<>(savedBooking.getId(), HttpStatus.CREATED);
	}

	/**
	 * Request to update a booking in the system
	 * @param theBooking the Booking you want to update.
	 * @return
	 */
	@PutMapping("/bookings")
	public ResponseEntity<?> updateBooking(@RequestBody Booking theBooking) {
		bookingService.update(theBooking);
		return new ResponseEntity<>(theBooking, HttpStatus.OK);
	}

	/**
	 * Request to delete a booking in the system
	 * @param bookingId the Booking id you want to delete.
	 * @return
	 */
	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<?> deleteBooking(@PathVariable @NotNull Long bookingId) {
		bookingService.deleteById(bookingId);
		return new ResponseEntity<>(Utils.convertMsgToJson("message", "Reserva com id " + bookingId + " deletado com sucesso."), HttpStatus.OK);
	}

	@PostMapping("/bookings/schedule")
	public ResponseEntity<?> scheduleBooking(@RequestParam @NotBlank String name, 
											@RequestParam String phoneNumber,
											@RequestParam @NotBlank @Email String email,
											@RequestParam @NotEmpty List<String> period,
											@RequestParam @NotBlank String hotel,
											@RequestParam String bookingType,
											@RequestParam String remarks) throws ParseException {
		JsonNode bookingNumber = bookingService.scheduleBooking(name, phoneNumber, email, period, hotel, bookingType, remarks);
		return new ResponseEntity<>(bookingNumber, HttpStatus.OK);		
	}

	@GetMapping("/bookings/consult")
	public ResponseEntity<?> consultBooking(@RequestParam @NotBlank String bookingNumber, 
											@RequestParam @NotBlank String hotel,
											@RequestParam @NotBlank String bookingType,
											@RequestParam @NotEmpty List<String> period) throws ParseException {
		ResponseBooking booking = bookingService.consultBooking(Long.parseLong(bookingNumber), period, hotel, bookingType);
			return new ResponseEntity<>(booking, HttpStatus.OK);	
	}

	/**
	 * Request to cancel a booking in the system
	 * @param theBooking the Booking you want to update.
	 * @return
	 */
	@PutMapping("/bookings/cancel")
	public ResponseEntity<?> cancelBooking(@RequestParam @NotBlank String bookingNumber) {
			JsonNode msg = bookingService.cancelBooking(Long.parseLong(bookingNumber));
			return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
