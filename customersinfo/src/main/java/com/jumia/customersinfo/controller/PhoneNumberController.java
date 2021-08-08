package com.jumia.customersinfo.controller;

import com.jumia.customersinfo.entity.PhoneNumber;
import com.jumia.customersinfo.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jumia-customers")
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "phone-numbers", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomers(@RequestParam(value = "country", required = false) String country,
                                          @RequestParam(value = "state", required = false) String numberState,
                                          @RequestParam(value = "pageNum", required = false) Integer pageNumber,
                                          @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        Page<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumbers(pageSize, pageNumber, country, numberState);
        return ResponseEntity.ok(phoneNumberList);
    }
}
