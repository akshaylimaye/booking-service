package com.paypal.bfs.test.bookingserv.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    private Integer addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Integer pincode;

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Column(name = "address_Line1")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name = "address_line2", nullable = true)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(name = "user_city")
    public String getCity() {
        return city;
    }

    public void setCity(String userCity) {
        this.city = userCity;
    }

    @Column(name = "user_state")
    public String getState() {
        return state;
    }

    public void setState(String userState) {
        this.state = userState;
    }

    @Column(name = "pincode")
    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

}

