package br.com.projects.hotelreservationservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity that stores the addresses
 * @author André
 */
@Entity
@Table(name = "address")
public class Address {

    // ################ attributes #################

    /** Address identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", unique = true)
    private Long id;

    /** Brief description of the type of address: home, work, etc. */
    @Column(name = "description")
    private String description;

    /** Street's name */
    @Column(name = "street")
    private String street;

    /** House number */
    @Column(name = "number")
    private int number;
    
    /** Neighborhood name */
    @Column(name = "neighborhood")
    private String neighborhood;

    /** City name */
    @Column(name = "city")
    private String city;

    /** State name */
    @Column(name = "state")
    private String state;

    /** Country name */
    @Column(name = "country")
    private String country;

    
    // ################ Constructors #################
    
    public Address() {
    }

    
    public Address(String description, String street, int number, String neighborhood, String city, String state,
            String country) {
        this.description = description;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
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


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public String getNeighborhood() {
        return neighborhood;
    }


    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }
    


    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", description=" + description + ", id=" + id
                + ", neighborhood=" + neighborhood + ", number=" + number + ", state=" + state + ", street=" + street
                + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((neighborhood == null) ? 0 : neighborhood.hashCode());
        result = prime * result + number;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (neighborhood == null) {
            if (other.neighborhood != null)
                return false;
        } else if (!neighborhood.equals(other.neighborhood))
            return false;
        if (number != other.number)
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (street == null) {
            if (other.street != null)
                return false;
        } else if (!street.equals(other.street))
            return false;
        return true;
    }

    
    
}
