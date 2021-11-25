package br.com.projects.hotelreservationservice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class to represent a customer
 * @author André
 */
@Entity
@Table(name = "customer")
public class Customer extends Person{

    // ################ attributes #################
    /** CPF number */
    @Column(name = "cpf", unique = true, nullable = false, insertable = true, updatable = true)
    private String cpf;

    /** Customer loyalty program's kind. */
    @Column(name = "loyalty", nullable = false, insertable = true, updatable = true)
    private LoyaltyProgram loyalty;


    // ################ Constructors #################
    public Customer(){

    }

    public Customer(Person person, String cpf) {
        super(person);
        this.cpf = cpf;
        this.loyalty = LoyaltyProgram.REGULAR;
    }

    public Customer(Person person, String cpf, LoyaltyProgram loyalty) {
        super(person);
        this.cpf = cpf;
        this.loyalty = loyalty;
    }

    public Customer(String name, String phoneNumber, String email, Address address, String cpf,
            LoyaltyProgram loyalty) {
        super(name, phoneNumber, email, address);
        this.cpf = cpf;
        this.loyalty = loyalty;
    }



    // ################ Getters/Setters #################
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
        return "Customer [name:" + getName() + " cpf=" + cpf + ", loyalty=" + loyalty + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((loyalty == null) ? 0 : loyalty.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (loyalty != other.loyalty)
            return false;
        return true;
    }

    
    


    

}
