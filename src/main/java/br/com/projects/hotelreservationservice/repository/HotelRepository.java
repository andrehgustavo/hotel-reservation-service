package br.com.projects.hotelreservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Hotel;
/**
 * A Hotel repository to handle database comunication.
 * @author André Gustavo
 */
@RepositoryRestResource(path = "hotels")
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
    /**
     * Retrieves a Hotel by its name.
     * @param name must not be null
     * @return the Hotel with the given name.
     */
    public Hotel findByName(String name);

}
