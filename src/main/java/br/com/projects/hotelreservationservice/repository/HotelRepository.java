package br.com.projects.hotelreservationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Hotel;

@RepositoryRestResource(path = "hotels")
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
    public Hotel findByName(String name);

}
