package com.jumia.customersinfo.service;

import com.jumia.customersinfo.entity.PhoneNumber;

public interface CountryService {
    public PhoneNumber extractPhoneNumberInfo(String number);
}
