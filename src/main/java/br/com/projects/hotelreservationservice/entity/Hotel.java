package br.com.projects.hotelreservationservice.entity;

import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class to represent a Hotel
 * @author André
 */
@Entity
@Table(name = "hotel")
public class Hotel extends Person{
    
    // ################ attributes #################
    /** CNPJ number */
    @Column(name = "cnpj", unique = true, nullable = false, insertable = true, updatable = true)
    private String cnpj;

    /** Hotel classification in star's number */
    @Column(name = "classification", nullable = false, insertable = true, updatable = true)
    private int classification;

    /** Hotel rate table. Ex: Regular, Special, High_Season... */
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rate", unique = false, nullable = true, insertable = true, updatable = true)
    private Map<String, Rate> tableRate;
    
    // ################ Constructors #################
    public Hotel(){
    }

    public Hotel(String name, String phoneNumber, String email, Address address, String cnpj, int classification,
            Map<String, Rate> tableRate) {
        super(name, phoneNumber, email, address);
        this.cnpj = cnpj;
        this.classification = classification;
        this.tableRate = tableRate;
    }

    // ################ Getters/Setters #################
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
        return "Hotel [name:" + getName() + "classification=" + classification + ", cnpj=" + cnpj + ", tableRate=" + tableRate + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + classification;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((tableRate == null) ? 0 : tableRate.hashCode());
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
        Hotel other = (Hotel) obj;
        if (classification != other.classification)
            return false;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        if (tableRate == null) {
            if (other.tableRate != null)
                return false;
        } else if (!tableRate.equals(other.tableRate))
            return false;
        return true;
    }

    
    

    
}
