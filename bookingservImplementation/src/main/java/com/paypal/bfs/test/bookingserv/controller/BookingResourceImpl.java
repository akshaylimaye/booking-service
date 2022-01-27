package com.paypal.bfs.test.bookingserv.controller;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.dao.AddressDao;
import com.paypal.bfs.test.bookingserv.api.dao.BookingDao;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.api.service.AddressService;
import com.paypal.bfs.test.bookingserv.api.service.BookingService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingDao bookingRepo;

    @Autowired
    AddressDao addressDao;

    @Autowired
    AddressService addressService;

    @Autowired
    BookingService bookingService;

    @Override
    public ResponseEntity<String> create(Booking booking) {
        List<String> validationList = null;

        if(null != booking){
            validationList = addressService.validateAddress(booking.getAddress());
            validationList = bookingService.validateBookings(booking, validationList);
        }

        if(null == validationList || !validationList.isEmpty()){
            String validationArr = JSONArray.toJSONString(validationList);
            return new ResponseEntity<String>("Please verify followings- "+ validationArr, HttpStatus.BAD_REQUEST);
        }
        try{
            addressDao.save(booking.getAddress());
            bookingRepo.save(booking);

        }catch (Exception ex){
            //Logging exception here with cause
            return new ResponseEntity<String>("Internal Server error" , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>("saved", HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<List<Booking>> getBookings() {
        ResponseEntity<List<Booking>> result = new ResponseEntity<List<Booking>>(bookingRepo.findAll(), HttpStatus.OK) ;
        return result;
    }

}