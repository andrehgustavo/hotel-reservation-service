package br.com.projects.hotelreservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Address;

/**
 * An Address repository to handle database comunication.
 * @author André Gustavo
 */
@RepositoryRestResource(path = "addresses")
public interface AddressRepository extends JpaRepository<Address, Long>{
    
    /**
     * Retrieves an Address by its description.
     * @param description must not be null
     * @return the Address with the given description.
     */
    public Address findByDescription(String description);
    
}
