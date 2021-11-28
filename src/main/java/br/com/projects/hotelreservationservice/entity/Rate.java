package br.com.projects.hotelreservationservice.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

/**
 * A Class to manipulate all Hotel's Rate.
 */
@Entity
@Table(name = "rate")
public class Rate implements Serializable{

    // ################ attributes #################
    /** Rate identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rate", unique = true)
    private Long id;

    /** Brief description of the rate's type: weekdays, weekend, high_season. */
    @Column(name = "description")
    private String description;

    /** Map name. */
    @Column(name = "price_type")
    private String priceType;
    

    /** An Array with 7 double fields representing the price of each week days. Ex: [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday] */
    @ElementCollection
    @CollectionTable(name = "price_per_days", 
      joinColumns = {@JoinColumn(name = "id_rate", referencedColumnName = "id_rate")})
    @MapKeyColumn(name = "name")
    @Column(name = "price")
    private Map<String, Double> pricePerDays;

    // ################ Constructors #################
    public Rate(){

    }

    public Rate(String description, String priceType, Map<String, Double> pricePerDays) {
        this.description = description;
        this.priceType = priceType;
        this.pricePerDays = pricePerDays;
    }

    // ################ Getters/Setters #################
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Double> getPricePerDays() {
        return pricePerDays;
    }

    public void setPricePerDays(Map<String, Double> pricePerDays) {
        this.pricePerDays = pricePerDays;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
    
    

    

}
