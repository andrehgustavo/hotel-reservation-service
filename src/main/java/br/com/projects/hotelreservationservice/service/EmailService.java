package br.com.projects.hotelreservationservice.service;

import br.com.projects.hotelreservationservice.entity.Booking;

/**
 * Email Service.
 * 
 * @author André Gustavo
 */
public interface EmailService {

    public String sendInformationMail(int status, Booking booking);
}
