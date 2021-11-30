package br.com.projects.hotelreservationservice.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * Entity to handle all the hotel booking.
 * @author André
 */
@Entity
@Table(name = "booking")
public class Booking implements Serializable{

    // ################ attributes #################
    /** Booking identifier.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking", unique = true)
    private Long id;

    /** Customer associated with a booking.*/
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "id_customer")
    private Customer customer;

    /** Hotel booking date.*/
    @Column(name = "booking_date")
    private Timestamp bookingDate;

    /** Hotel check-in date.*/
    @Column(name = "checkin")
    private Date checkin;

    /** Hotel check-out date.*/
    @Column(name = "checkout")
    private Date checkout;

    /** Hotel associated with a booking.*/
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    /** Booking type: Regular or Reward */
    @Column(name = "booking_type")
    private LoyaltyProgram type;
    
    /** Booking remarks. Describe any booking peculiarity; */
    @Column(name = "booking_remarks")
    private String remarks;
    
    /** Booking number.*/
    @Column(name = "booking_number", unique = true)
    private Long number;

    /** Booking price.*/
    @Column(name = "booking_price")
    private Double price;

    /** Show if the booking is active or not.*/
    @Column(name = "active")
    private Boolean active;
    
    // ################ Constructors #################
    public Booking(){
    }

    public Booking(Customer customer, Hotel hotel, Date checkout, Date checkin, LoyaltyProgram type, String remarks) {
        this.customer = customer;
        this.checkin = checkin;
        this.checkout = checkout;
        this.hotel = hotel;
        this.type = type;
        this.remarks = remarks;
        this.bookingDate = new Timestamp(System.currentTimeMillis());
        this.active = true;
    }

    public Booking(Customer customer, Hotel hotel, Date checkout, Date checkin, LoyaltyProgram type, String remarks, Long bookingNumber, double price) {
        this.customer = customer;
        this.checkin = checkin;
        this.checkout = checkout;
        this.hotel = hotel;
        this.type = type;
        this.remarks = remarks;
        this.number = bookingNumber;
        this.price = price;
        this.bookingDate = new Timestamp(System.currentTimeMillis());
        this.active = true;
    }

    // ################ Getters/Setters #################
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LoyaltyProgram getType() {
        return type;
    }

    public void setType(LoyaltyProgram type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Boolean getActive() {
        return active;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Booking [active=" + active + ", bookingDate=" + bookingDate + ", checkin=" + checkin + ", checkout="
                + checkout + ", customer=" + customer + ", hotel=" + hotel + ", id=" + id + ", number=" + number
                + ", price=" + price + ", remarks=" + remarks + ", type=" + type + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
        result = prime * result + ((checkin == null) ? 0 : checkin.hashCode());
        result = prime * result + ((checkout == null) ? 0 : checkout.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Booking other = (Booking) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (bookingDate == null) {
            if (other.bookingDate != null)
                return false;
        } else if (!bookingDate.equals(other.bookingDate))
            return false;
        if (checkin == null) {
            if (other.checkin != null)
                return false;
        } else if (!checkin.equals(other.checkin))
            return false;
        if (checkout == null) {
            if (other.checkout != null)
                return false;
        } else if (!checkout.equals(other.checkout))
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (hotel == null) {
            if (other.hotel != null)
                return false;
        } else if (!hotel.equals(other.hotel))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (remarks == null) {
            if (other.remarks != null)
                return false;
        } else if (!remarks.equals(other.remarks))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    // ################ Methods #################
    /**
     * Method to calculate booking number of days
     * @return int - booking number of days
     */
    public int getBookingPeriod(){
        return Days.daysBetween(new LocalDate(this.checkin), new LocalDate(this.checkout)).getDays();
    }
    
    /**
     * Method for calculating the number of weekdays and weekend days in a period.
     * @return returns an array where the first position is the number of days in the weekdays, and the second position is the number of days in the weekend. 
     * 
     * @author jmj(https://www.hudatutorials.com/java/basics/java-arrays/java-double-array)
     */
    public static int[] getWeekDays(Date dateStart, Date dateEnd){
        int result[] = new int[2];
        DateTime startDt = new DateTime(dateStart);
        DateTime endDt = new DateTime(dateEnd);
        DateTime tempDate = new DateTime(startDt.getMillis());
        while(tempDate.compareTo(endDt) <=0 ){
            if(tempDate.getDayOfWeek() !=  DateTimeConstants.SATURDAY && tempDate.getDayOfWeek() !=  DateTimeConstants.SUNDAY){
                System.out.println(""+tempDate);
                ++result[0];
            }else{
                ++result[1];
            }
            tempDate = tempDate.plusDays(1);            
        }
        return result;
    }

}
