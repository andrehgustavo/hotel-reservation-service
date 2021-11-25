package br.com.projects.hotelreservationservice.entity;

import java.util.Map;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A Class to manipulate all Hotel's Rate.
 */
@Entity
@Table(name = "rate")
public class Rate {

    // ################ attributes #################
    /** Rate identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rate", unique = true, nullable = false, insertable = true, updatable = true)
    private Long id;

    /** Brief description of the rate's type: weekdays, weekend, high_season. */
    @Column(name = "description", unique = true, nullable = false, insertable = true, updatable = true)
    private String description;

    /** An Array with 7 double fields representing the price of each week days. Ex: [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday] */
    @Column(name = "price_per_day", nullable = false, insertable = true, updatable = true)
    private double[] pricePerDays = new double[7];

    // ################ Constructors #################
    public Rate(){

    }

    public Rate(String description, double[] pricePerDays) {
        this.description = description;
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

    public double[] getPricePerDays() {
        return pricePerDays;
    }

    public void setPricePerDays(double[] pricePerDays) {
        this.pricePerDays = pricePerDays;
    }
    

    

}
