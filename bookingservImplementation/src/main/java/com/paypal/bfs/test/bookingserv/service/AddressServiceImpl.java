package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public List<String> validateAddress(Address address) {
        List<String> validate = new ArrayList<>();
        if(null == address.getAddressLine1() || address.getAddressLine1().isEmpty()){
            validate.add("Address line 1 can't be empty");
        }
        if(null == address.getCity() || address.getCity().isEmpty()){
            validate.add("City can't be empty");
        }
        if(null == address.getPincode() || !pinCodeValidation(address.getPincode())){
            validate.add("Please enter a valid pincode");
        }
        if(null == address.getState() || address.getState().isEmpty()){
            validate.add("State can't be empty");
        }
        return validate;
    }

    private boolean pinCodeValidation(int pincode){
        String regex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
        Pattern p = Pattern.compile(regex);
        return p.matcher(String.valueOf(pincode)).matches();
    }
}
