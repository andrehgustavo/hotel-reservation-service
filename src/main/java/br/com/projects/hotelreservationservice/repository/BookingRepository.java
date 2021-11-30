package br.com.projects.hotelreservationservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Booking;

@RepositoryRestResource(path = "bookings")
public interface BookingRepository extends JpaRepository<Booking, Long>{

    boolean existsByNumber(Long bookingNumber);

    Optional<Booking> findByNumber(Long bookingNumber);

    @Query("select b from Booking b where b.active=TRUE")
    List<Booking> findAllbyActive();
    
}
