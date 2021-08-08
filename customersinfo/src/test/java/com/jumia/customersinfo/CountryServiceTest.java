package com.jumia.customersinfo;

import com.jumia.customersinfo.entity.PhoneNumber;
import com.jumia.customersinfo.entity.enums.PhoneNumberState;
import com.jumia.customersinfo.service.CountryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountryServiceTest {

    @Autowired
    CountryService countryService;

    @Test
    void testExtractPhoneNumberInfo() {
        PhoneNumber phoneNumber = new PhoneNumber(null, "(256) 775069443", "Uganda", "256", PhoneNumberState.VALID);

        Assert.assertEquals(countryService.extractPhoneNumberInfo("(256) 775069443"), phoneNumber);
    }
}
