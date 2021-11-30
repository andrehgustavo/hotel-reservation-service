package br.com.projects.hotelreservationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Customer;

@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    public Customer findByName(String name);

    public Customer findByEmail(String email);
}
