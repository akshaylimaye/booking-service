package com.paypal.bfs.test.bookingserv.api.dao;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
