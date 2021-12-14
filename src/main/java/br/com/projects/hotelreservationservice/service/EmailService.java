package br.com.projects.hotelreservationservice.service;

import br.com.projects.hotelreservationservice.entity.Booking;

/**
 * Email Service.
 * 
 * @author André Gustavo
 */
public interface EmailService {

    /**
     * Service to send a advice mail to the customer
     * @param status If it's a booking confirmation or cancellation email (BookinService.CONFIRMED or BookingService.CANCELLED)
     * @param booking The booking
     * @return
     */
    public String sendInformationMail(int status, Booking booking);
}
