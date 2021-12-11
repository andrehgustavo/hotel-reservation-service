package br.com.projects.hotelreservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Customer;

/**
 * A Customer repository to handle database comunication.
 * @author André Gustavo
 */
@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    /**
     * Retrieves a Customer by its name.
     * @param name must not be null
     * @return the Customer with the given name.
     */
    public Customer findByName(String name);

    /**
     * Retrieves a Customer by its email.
     * @param email must not be null
     * @return the Customer with the given email.
     */
    public Customer findByEmail(String email);
}
