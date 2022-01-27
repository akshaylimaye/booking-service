package com.paypal.bfs.test.bookingserv.api.dao;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, Integer> {
}
