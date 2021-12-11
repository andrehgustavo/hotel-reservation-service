package br.com.projects.hotelreservationservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Booking;
/**
 * A Booking repository to handle database comunication.
 * @author André Gustavo
 */
@RepositoryRestResource(path = "bookings")
public interface BookingRepository extends JpaRepository<Booking, Long>{
    
    /**
     * Check if exists a Booking with a booking number in database.
     * @param bookingNumber must not be null.
     * @return true or false wheter there is or there isn't 
     */
    boolean existsByNumber(Long bookingNumber);

    /**
     * Retrieves a Booking by its description.
     * @param bookingNumber must not be null.
     * @return the Booking with the given description.
     */
    Optional<Booking> findByNumber(Long bookingNumber);

    /**
     * Returns all active instances of Booking.
     * @return all active Bookings
     */
    @Query("select b from Booking b where b.active=TRUE")
    List<Booking> findAllbyActive();
    
}
