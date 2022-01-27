package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.api.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public List<String> validateBookings(Booking booking, List<String> validate) {
        if(null == booking.getFirstName() || booking.getFirstName().isEmpty()){
            validate.add("First name can't be empty");
        }
        if(null == booking.getLastName() || booking.getLastName().isEmpty()){
            validate.add("Last name can't be empty");
        }
        if(null == booking.getDateOfBirth()){
            validate.add("Date of birth can't be empty or please provide in MM/dd/yyyy pattern");
        }
        if(null == booking.getDeposit() || booking.getDeposit() == 0){
            validate.add("Deposit can't be 0");
        }
        if(null == booking.getTotalPrice() || booking.getTotalPrice() == 0){
            validate.add("Total price can't be 0");
        }
        if(null != booking.getCheckInTime() && null  != booking.getCheckOutTime()){
                if(booking.getCheckInTime().after(booking.getCheckOutTime())){
                    validate.add("Check-in time should be before check-out time");
                }
        }else{
            validate.add("Please varify check-in and check-out time");
        }



        return validate;
    }

}
