package br.com.projects.hotelreservationservice.controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;

import br.com.projects.hotelreservationservice.entity.Address;
import br.com.projects.hotelreservationservice.entity.Booking;
import br.com.projects.hotelreservationservice.entity.Customer;
import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.entity.LoyaltyProgram;
import br.com.projects.hotelreservationservice.service.BookingServiceImpl;
import br.com.projects.hotelreservationservice.service.CustomerServiceImpl;
import br.com.projects.hotelreservationservice.service.HotelServiceImpl;
import br.com.projects.hotelreservationservice.utils.Utils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
	private MockMvc mockMvc;

    @Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private BookingServiceImpl bookingService;
    @MockBean
    private HotelServiceImpl hotelService;
	@MockBean
    private CustomerServiceImpl customerService;

    @Test
	public void testListAllBookingsReturnsStatus200() throws Exception {
        List<Booking> listBooking = new ArrayList<Booking>();
        listBooking.add(new Booking(1L, new Customer("Andre", "8499999999", "andre@teste.com.br"), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel(), LoyaltyProgram.REGULAR, "Cama extra", 2021L, 180.0, true));
        listBooking.add(new Booking(2L, new Customer("Andre", "8499999999", "andre@teste.com.br"), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel(), LoyaltyProgram.REGULAR, "Cama extra", 2021L, 180.0, true));
        listBooking.add(new Booking(3L, new Customer("Andre", "8499999999", "andre@teste.com.br"), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel(), LoyaltyProgram.REGULAR, "Cama extra", 2021L, 180.0, true));
        listBooking.add(new Booking(4L, new Customer("Andre", "8499999999", "andre@teste.com.br"), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel(), LoyaltyProgram.REGULAR, "Cama extra", 2021L, 180.0, true));
        listBooking.add(new Booking(5L, new Customer("Andre", "8499999999", "andre@teste.com.br"), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel(), LoyaltyProgram.REGULAR, "Cama extra", 2021L, 180.0, true));
    
    
        Mockito.when(bookingService.findAll()).thenReturn(listBooking);

        String url = "/bookings";

        MvcResult mvcResult = mockMvc.perform(
				get(url))
				.andExpect(status()
				.isOk()
			).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		String expectedJsonResponse = objectMapper.writeValueAsString(listBooking);
		
		assertThat(actualJsonResponse).isEqualToIgnoringCase(expectedJsonResponse);
    }

    @Test
	public void testCreateNewBookingReturnsStatus201() throws JsonProcessingException, Exception {
		Booking newBooking = new Booking();
		Booking savedBooking = new Booking(1L);
		
		Mockito.when(bookingService.save(newBooking)).thenReturn(savedBooking);
		
		String url = "/bookings";
		mockMvc.perform(
				post(url).
				contentType("application/json").
				content(objectMapper.writeValueAsString(newBooking))
        ).andExpect(status().isCreated())
		.andExpect(content().string("1"));
	}

    @Test
	public void testUpdateBookingReturnsStatus200() throws JsonProcessingException, Exception {

		Booking newBooking =  new Booking(89L, new Customer("Andre23", "8499999999", "andre23@teste.com.br", new Address("Endereço", "street", 25, "neighborhood", "city", "state", "country"), "067.923.304-00", LoyaltyProgram.REGULAR), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel("teste Hotel"), LoyaltyProgram.REGULAR, "Cama extra", 2021L, 180.0, true);
		Booking savedBooking = new Booking(89L, new Customer("Andre23", "8499999999", "andre23@teste.com.br", new Address("Endereço", "street", 25, "neighborhood", "city", "state", "country"), "067.923.304-00", LoyaltyProgram.REGULAR), Timestamp.valueOf("2021-12-11 14:00:00"), Date.valueOf("2021-12-11"), Date.valueOf("2021-12-15"), new Hotel("teste Hotel"), LoyaltyProgram.REGULAR, "Cama extra", 2021L, 180.0, true);

		
		Mockito.when(bookingService.update(newBooking)).thenReturn(savedBooking);
		
		String url = "/bookings";
		mockMvc.perform(put(url)
				.content(objectMapper.writeValueAsString(newBooking))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("id", is((int) (long) newBooking.getId())));
	}

    @Test
	public void testDeleteBookingReturnStatus200() throws Exception {
		Long bookingId = 90L;
		Mockito.doNothing().when(bookingService).deleteById(bookingId);
		String url = "/bookings/" + bookingId;
		mockMvc.perform(delete(url)).andExpect(status().isOk());
		Mockito.verify(bookingService, times(1)).deleteById(bookingId);	
	}

    @Test
	public void testScheduleBookingReturnsStatus201() throws JsonProcessingException, Exception {

		List<String> periodo = new ArrayList<String>();
        periodo.add("28/11/2021");
        periodo.add("26/11/2021");
        periodo.add("27/11/2021");
		Mockito.when(bookingService.scheduleBooking("Andre", "8499999999", "andreh_gustavo@hotmail.com", periodo, "Lakewood", "Regular", "Cama extra")).thenReturn(Utils.convertMsgToJson("bookingNumber", "192625"));
		
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("name", "Andre");
        requestParams.add("phoneNumber", "8499999999");
        requestParams.add("email", "andreh_gustavo@hotmail.com");
        requestParams.add("period", "28/11/2021, 26/11/2021, 27/11/2021");
        requestParams.add("hotel", "Lakewood");
        requestParams.add("bookingType", "Regular");
        requestParams.add("remarks", "Cama extra");

		String url = "/bookings/schedule";

        MvcResult mvcResult = mockMvc.perform(
            post(url).
            params(requestParams).
            contentType("application/json")
            ).andExpect(status().isOk()
		).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		String expectedJsonResponse = objectMapper.writeValueAsString(Utils.convertMsgToJson("bookingNumber", "192625"));
		
		assertThat(actualJsonResponse).isEqualToIgnoringCase(expectedJsonResponse);
	}

}
