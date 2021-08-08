package com.jumia.customersinfo.service;

import com.jumia.customersinfo.entity.Customer;
import com.jumia.customersinfo.entity.PhoneNumber;
import com.jumia.customersinfo.entity.enums.PhoneNumberState;
import com.jumia.customersinfo.repository.CustomerRepository;
import com.jumia.customersinfo.repository.PhoneNumberRepository;
import com.jumia.customersinfo.util.PageRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    CountryService countryService;

    public void initPhoneNumbersData() {
        if (phoneNumberRepository.count() == 0) {
            List<Customer> customerList = customerRepository.findAll();
            List<PhoneNumber> phoneNumberList = new ArrayList<>();
            for (Customer customer : customerList) {
                PhoneNumber phoneNumber = countryService.extractPhoneNumberInfo(customer.getPhone());
                phoneNumberList.add(phoneNumber);
            }
            phoneNumberRepository.saveAll(phoneNumberList);
        }
    }

    public Page<PhoneNumber> getPhoneNumbers(Integer pageSize, Integer pageNum, String country, String state) {
        PageRequest pageRequest = PageRequestBuilder.build(pageNum, pageSize);
        Page<PhoneNumber> phoneNumberList;
        if (country != null && state != null) {
            phoneNumberList = phoneNumberRepository.findByStateAndCountry(PhoneNumberState.valueOf(state), country, pageRequest);
        } else if (country != null) {
            phoneNumberList = phoneNumberRepository.findByCountry(country, pageRequest);
        } else if (state != null) {
            phoneNumberList = phoneNumberRepository.findByState(PhoneNumberState.valueOf(state), pageRequest);
        } else {
            phoneNumberList = phoneNumberRepository.findAll(pageRequest);
        }
        return phoneNumberList;
    }
}
