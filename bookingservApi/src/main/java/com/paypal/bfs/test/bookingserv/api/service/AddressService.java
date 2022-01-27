package com.paypal.bfs.test.bookingserv.api.service;

import com.paypal.bfs.test.bookingserv.api.model.Address;

import java.util.List;

public interface AddressService {

    public List<String> validateAddress(Address address);
}
