package br.com.projects.hotelreservationservice.entity;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 * This is a response class to return a booking message.
 */
public class ResponseBooking {

    private Long bookingNumber;

    private String name;

    private String phoneNumber;

    private String email;

    private Date[] period = new Date[2]; 

    private String hotel;

    private String type;

    private String price;

    public ResponseBooking(Long bookingNumber, String name, String phoneNumber, String email, Date[] period,
            String hotel, String type, String price) {
        this.bookingNumber = bookingNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.period = period;
        this.hotel = hotel;
        this.type = type;
        this.price = price;
    }

    public ResponseBooking(Booking theBooking){
        DecimalFormat df = new DecimalFormat("#,###.00");
        this.bookingNumber = theBooking.getNumber();
        this.name = theBooking.getCustomer().getName();
        this.phoneNumber = theBooking.getCustomer().getPhoneNumber();
        this.email = theBooking.getCustomer().getEmail();
        this.period[0] = theBooking.getCheckin();
        this.period[1] = theBooking.getCheckout();
        this.hotel = theBooking.getHotel().getName();
        this.type =  theBooking.getType().toString();
        this.price = "R$" + df.format(theBooking.getPrice());
    }

    public Long getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Long bookingNumber) {
        this.bookingNumber = bookingNumber;
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

    public Date[] getPeriod() {
        return period;
    }

    public void setPeriod(Date[] period) {
        this.period = period;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
