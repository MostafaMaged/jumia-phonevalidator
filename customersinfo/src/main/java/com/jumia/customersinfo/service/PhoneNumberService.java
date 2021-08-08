package com.jumia.customersinfo.service;

import com.jumia.customersinfo.entity.PhoneNumber;
import org.springframework.data.domain.Page;

public interface PhoneNumberService {
    void initPhoneNumbersData();

    Page<PhoneNumber> getPhoneNumbers(Integer pageSize, Integer pageNum, String country, String state);
}
