package br.com.projects.hotelreservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.projects.hotelreservationservice.entity.Rate;

@RepositoryRestResource(path = "rates")
public interface RateRepository extends JpaRepository<Rate, Long>{
    
    public Rate findByDescription(String description);
    
}
