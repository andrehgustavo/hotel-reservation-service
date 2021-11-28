package br.com.projects.hotelreservationservice.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class to represent a customer
 * @author André
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable{

    // ################ attributes #################
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel", unique = true)
    private Long id;

    /** Person/company name */
    @Column(name = "name")
    private String name;

    /** Person/company telephone number */
    @Column(name = "phone_number")
    private String phoneNumber;

    /** Person/company email */
    @Column(name = "email", unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address = new Address();
    
    /** CPF number */
    @Column(name = "cpf", unique = true)
    private String cpf;

    /** Customer loyalty program's kind. */
    @Column(name = "loyalty")
    private LoyaltyProgram loyalty;


    // ################ Constructors #################
    public Customer(){

    }

    public Customer(String name, String phoneNumber, String email, Address address, String cpf,
            LoyaltyProgram loyalty) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.cpf = cpf;
        this.loyalty = loyalty;
    }

    public Customer(String name, String phoneNumber, String email, Address address, String cpf) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.cpf = cpf;
        this.loyalty = LoyaltyProgram.REGULAR;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LoyaltyProgram getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(LoyaltyProgram loyalty) {
        this.loyalty = loyalty;
    }
    
    @Override
    public String toString() {
        return "Customer [address=" + address + ", cpf=" + cpf + ", email=" + email + ", id=" + id + ", loyalty="
                + loyalty + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((loyalty == null) ? 0 : loyalty.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
        Customer other = (Customer) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
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
        if (loyalty != other.loyalty)
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
        return true;
    }
    

}
