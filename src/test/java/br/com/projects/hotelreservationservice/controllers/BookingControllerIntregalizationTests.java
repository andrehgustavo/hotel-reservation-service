package br.com.projects.hotelreservationservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import br.com.projects.hotelreservationservice.entity.Booking;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingControllerIntregalizationTests {


    @LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;



    @Test 
    void testGetAllReturn200() {
		ResponseEntity<Booking[]> res = testRestTemplate.getForEntity("http://localhost:" + port + "/hotel-reservation/api/v1/bookings", Booking[].class);
		
		Booking[] bookings = res.getBody();
		
		assertEquals(2, bookings.length);
		assertEquals(200, res.getStatusCodeValue());
	}

}
