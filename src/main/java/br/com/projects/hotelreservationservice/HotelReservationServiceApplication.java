package br.com.projects.hotelreservationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationServiceApplication.class, args);
		System.out.println("Aplicação no ar 🚀! Vá para http://localhost:8084/");

	}

}
