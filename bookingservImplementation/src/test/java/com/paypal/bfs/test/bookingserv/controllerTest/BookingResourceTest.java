package com.paypal.bfs.test.bookingserv.controllerTest;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.controller.BookingResourceImpl;
import com.paypal.bfs.test.bookingserv.service.AddressServiceImpl;
import org.json.simple.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingResourceTest {

    @Autowired
    private BookingResourceImpl bookingController;

    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    static private Address address;

    @Autowired
    static private Booking booking;

    @BeforeClass
    public static void intialise(){
        address = new Address();
        booking = new Booking();
        address.setAddressLine1("line 1");
        address.setAddressLine2("line 2");
        address.setCity("Bengaluru");
        address.setPincode(540045);
        address.setState("Karnataka");
        Timestamp checkIn = new Timestamp(System.currentTimeMillis());
        booking.setCheckInTime(checkIn);
        Timestamp checkOut = new Timestamp(System.currentTimeMillis());
        booking.setCheckOutTime(checkOut);
        Date dateOfBirth = new Date();
        booking.setDateOfBirth(dateOfBirth);
        booking.setDeposit(10000);
        booking.setTotalPrice(1000);
        booking.setFirstName("Akshay");
        booking.setLastName("Limaye");
        booking.setAddress(address);
    }

    @Test
    public void bookingCreate(){
        ResponseEntity<String> expectedResponse = new ResponseEntity<String>("saved",HttpStatus.BAD_REQUEST);
        ResponseEntity<String> actualResponse = bookingController.create(booking);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void bookingCreatedFail1(){
        booking.setDateOfBirth(null);
        List<String> validation = new ArrayList<>();
        validation.add("Date of birth can't be empty or please provide in MM/dd/yyyy pattern");
        String validationArr = JSONArray.toJSONString(validation);
        ResponseEntity<String> expectedResponse = new ResponseEntity<String>("Please verify followings- " + validation,HttpStatus.BAD_REQUEST);
        ResponseEntity<String> actualResponse = bookingController.create(booking);
        assertEquals(expectedResponse, actualResponse);
    }

    public void bookingCreateFail2(){
        address.setState(null);
        List<String> validation = new ArrayList<>();
        validation.add("State can't be empty");
        String validationArr = JSONArray.toJSONString(validation);
        ResponseEntity<String> expectedResponse = new ResponseEntity<String>("Please verify followings- " + validation,HttpStatus.BAD_REQUEST);
        ResponseEntity<String> actualResponse = bookingController.create(booking);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void getBookings(){
        ResponseEntity<List<Booking>> expectedResponse = new ResponseEntity<List<Booking>>(new ArrayList<Booking>(), HttpStatus.OK);
        ResponseEntity<List<Booking>> actualResponse = bookingController.getBookings();
        assertNotNull(expectedResponse.getStatusCode().toString(), actualResponse.getStatusCode().toString());

    }
}
