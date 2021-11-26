package br.com.projects.hotelreservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Address;

@RepositoryRestResource(path = "addresses")
public interface AddressRepository extends JpaRepository<Address, Long>{
    
    public Address findByDescription(String description);
    
}
