package com.paypal.bfs.test.bookingserv.api.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.util.List;

public interface BookingService {

    public List<String> validateBookings(Booking booking, List<String> validateAddress);

}
