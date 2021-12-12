package br.com.projects.hotelreservationservice.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projects.hotelreservationservice.entity.Address;
import br.com.projects.hotelreservationservice.entity.Booking;
import br.com.projects.hotelreservationservice.entity.Customer;
import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.entity.LoyaltyProgram;
import br.com.projects.hotelreservationservice.entity.Rate;
import br.com.projects.hotelreservationservice.entity.ResponseBooking;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingControllerIntregalizationTests {


    @LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;

    @Test 
    void testGetAllBookingsReturn200() {
		
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings";

		ResponseEntity<Booking[]> res = testRestTemplate.getForEntity(url, Booking[].class);
		
		Booking[] bookings = res.getBody();
		// Local
		//assertEquals(16, bookings.length);
		//Remoto (GITHUB)
		assertEquals(2, bookings.length);
		assertEquals(200, res.getStatusCodeValue());
	}

	@Test 
    void testGetBookingByIdReturn200(){
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings/2";

		Booking booking = testRestTemplate.getForObject(url, Booking.class);
		
		assertEquals(2L, booking.getId());
	}

	@Test
	void testCreateBookingReturn201() throws URISyntaxException{
		Map<String, Double> regularPrices = new Hashtable<String, Double>();
		regularPrices.put("WEEKDAYS", 110.0);
		regularPrices.put("WEEKENDDAYS", 90.0);
		Rate regularRate = new Rate("Day type price for Regular customers", "REGULAR", regularPrices);
		Map<String, Rate> tableRate = new Hashtable<String, Rate>();
		
		Map<String, Double> rewardPrices = new Hashtable<String, Double>();
		rewardPrices.put("WEEKDAYS", 110.0);
		rewardPrices.put("WEEKENDDAYS", 90.0);
		Rate rewardRate = new Rate("Day type price for Reward customers", "REWARD", rewardPrices);
		
		tableRate.put("REGULAR", regularRate);
		tableRate.put("REWARD", rewardRate);
		
		Booking newBooking = new Booking(
			new Customer(4L, "Pedro", "84888554423", "andre@email.com", new Address(1L, "Residencial", "Rua tal", 2034, "Lagoa Nova", "Mossoró", "RN", "Brasil"), "000.000.000-17", LoyaltyProgram.REGULAR),
			new Hotel(1L, "Lakewood", "55 84 99998-55540", "contato@lakewood.com", new Address(3L, "Comercial",  "206 St", 103, "New Horizon", "Miami", "FL", "Estados Unidos"),  "000.000-0007-1", 3, tableRate), 
			Date.valueOf("2021-12-15"), 
			Date.valueOf("2021-12-11"), 
			LoyaltyProgram.REGULAR, 
			"Cama extra.");
		
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings";

		URI uri = new URI(url);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> result = testRestTemplate.exchange(RequestEntity.post(uri).header("X-COM-PERSIST", "true").body(newBooking), String.class);

		assertEquals(HttpStatus.CREATED, result.getStatusCode());

	}

	@Test
	void testUpdateBookingReturn200() throws JSONException, URISyntaxException{
		Map<String, Double> regularPrices = new Hashtable<String, Double>();
		regularPrices.put("WEEKDAYS", 110.0);
		regularPrices.put("WEEKENDDAYS", 90.0);
		Rate regularRate = new Rate(7L, "Day type price for Regular customers", "REGULAR", regularPrices);
		Map<String, Rate> tableRate = new Hashtable<String, Rate>();
		
		Map<String, Double> rewardPrices = new Hashtable<String, Double>();
		rewardPrices.put("WEEKDAYS", 110.0);
		rewardPrices.put("WEEKENDDAYS", 90.0);
		Rate rewardRate = new Rate(8L, "Day type price for Reward customers", "REWARD", rewardPrices);
		
		tableRate.put("REGULAR", regularRate);
		tableRate.put("REWARD", rewardRate);
		
		Booking updatedBooking = new Booking(1L, new Customer(4L, "Pedro", "84888554423", "andre@email.com", new Address(1L, "Residencial", "Rua tal", 2034, "Lagoa Nova", "Mossoró", "RN", "Brasil"), "000.000.000-17", LoyaltyProgram.REGULAR), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel(1L, "Lakewood", "55 84 99998-55540", "contato@lakewood.com", new Address(3L, "Comercial",  "206 St", 103, "New Horizon", "Miami", "FL", "Estados Unidos"),  "000.000-0007-1", 3, tableRate), LoyaltyProgram.REGULAR, "2 Camas extras.", 202345L, 280.0, true);
		
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings";

		URI uri = new URI(url);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> result = testRestTemplate.exchange(RequestEntity.put(uri).header("X-COM-PERSIST", "true").body(updatedBooking), String.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());

	}

	@Test 
    void testDeleteBookingByIdReturn200() throws URISyntaxException{
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings/1";

		URI uri = new URI(url);

		ResponseEntity<String> result = testRestTemplate.exchange(RequestEntity.delete(uri).build(), String.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test 
    void testScheduleABookingReturn200() throws JSONException{
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings";
		
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("name", "Andre Gustavo");
        requestParams.add("phoneNumber", "84999278557");
        requestParams.add("email", "andreh_gustavo@hotmail.com");
        requestParams.add("period", "28/11/2021, 26/11/2021, 27/11/2021");
        requestParams.add("hotel", "Lakewood");
        requestParams.add("bookingType", "Regular");
        requestParams.add("remarks", "Cama extra");

		URI uri = UriComponentsBuilder.fromHttpUrl(url).path("/schedule").queryParams(requestParams).build().toUri();
        
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(getJSONBooking().toString(), headers);
		
		ResponseEntity<Booking> result = this.testRestTemplate.postForEntity(uri, request, Booking.class);
		
		assertEquals(HttpStatus.OK, result.getStatusCode());

	}

	@Test 
    void testConsultABookingReturn200() throws JSONException{
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings";
		
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("bookingNumber", "1638243969183");
        requestParams.add("hotel", "Lakewood");
        requestParams.add("bookingType", "Regular");
        requestParams.add("period", "28/11/2021, 26/11/2021, 27/11/2021");

		URI uri = UriComponentsBuilder.fromHttpUrl(url).path("/consult").queryParams(requestParams).build().toUri();
		
		ResponseEntity<ResponseBooking> result = this.testRestTemplate.getForEntity(uri, ResponseBooking.class);
		
		assertEquals(HttpStatus.OK, result.getStatusCode());

	}

	@Test 
    void testConsultInvalidBookingNumberReturn404() throws JSONException{
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings";
		
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("bookingNumber", "16390438269");
        requestParams.add("hotel", "Lakewood");
        requestParams.add("bookingType", "Regular");
        requestParams.add("period", "28/11/2021, 26/11/2021, 27/11/2021");

		URI uri = UriComponentsBuilder.fromHttpUrl(url).path("/consult").queryParams(requestParams).build().toUri();
		
		ResponseEntity<ResponseBooking> result = this.testRestTemplate.getForEntity(uri, ResponseBooking.class);
		
		assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

	}

	@Test 
    void testCancelABookingReturn200() throws JSONException{
		final String url = "http://localhost:" + port + "/hotel-reservation/api/v1/bookings";

		URI uri = UriComponentsBuilder.fromHttpUrl(url).path("/cancel").queryParam("bookingNumber", "1638243969183").build().toUri();
        
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(getJSONCancelation().toString(), headers);
		
		ResponseEntity<Booking> result = this.testRestTemplate.postForEntity(uri, request, Booking.class);
		
		assertEquals(HttpStatus.OK, result.getStatusCode());

	}

	private JSONObject getJSONBooking() throws JSONException {
		JSONObject json = new JSONObject();

		json.put("name", "Andre Gustavo");
        json.put("phoneNumber", "84999278557");
        json.put("email", "andreh_gustavo@hotmail.com");
        json.put("period", "28/11/2021, 26/11/2021, 27/11/2021");
        json.put("hotel", "Lakewood");
        json.put("bookingType", "Regular");
        json.put("remarks", "Cama extra");
		
		return json;
	}

	private JSONObject getJSONCancelation() throws JSONException {
		JSONObject json = new JSONObject();

		json.put("bookingNumber", "1639335999368");
		
		return json;
	}


}
