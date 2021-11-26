package br.com.projects.hotelreservationservice.entity;

import java.io.Serializable;
import java.util.Map;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class to represent a Hotel
 * @author André
 */
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable{
    
    // ################ attributes #################
    /** Person identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel", unique = true)
    private Long id;

    /** Company name */
    @Column(name = "name")
    private String name;

    /** Company telephone number */
    @Column(name = "phone_number")
    private String phoneNumber;

    /** Company email */
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address = new Address();
    
    /** CNPJ number */
    @Column(name = "cnpj", unique = true)
    private String cnpj;

    /** Hotel classification in star's number */
    @Column(name = "classification")
    private int classification;

    /** Hotel rate table. Ex: Regular, Special, High_Season... */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotel_table_rate", 
      joinColumns = {@JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")},
      inverseJoinColumns = {@JoinColumn(name = "id_rate", referencedColumnName = "id_rate")})
    @MapKey(name = "description")
    private Map<String, Rate> tableRate;
    
    // ################ Constructors #################
    public Hotel(){
    }

    public Hotel(String name, String phoneNumber, String email, Address address, String cnpj, int classification,
            Map<String, Rate> tableRate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.cnpj = cnpj;
        this.classification = classification;
        this.tableRate = tableRate;
    }

    // ################ Getters/Setters #################
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public Map<String, Rate> getTableRate() {
        return tableRate;
    }

    public void setTableRate(Map<String, Rate> tableRate) {
        this.tableRate = tableRate;
    }

    @Override
    public String toString() {
        return "Hotel [address=" + address + ", classification=" + classification + ", cnpj=" + cnpj + ", email="
                + email + ", id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", tableRate=" + tableRate
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + classification;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((tableRate == null) ? 0 : tableRate.hashCode());
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
        Hotel other = (Hotel) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (classification != other.classification)
            return false;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (tableRate == null) {
            if (other.tableRate != null)
                return false;
        } else if (!tableRate.equals(other.tableRate))
            return false;
        return true;
    }    
    
}
