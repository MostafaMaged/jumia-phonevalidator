package com.jumia.customersinfo;

import com.jumia.customersinfo.entity.PhoneNumber;
import com.jumia.customersinfo.entity.enums.PhoneNumberState;
import com.jumia.customersinfo.repository.PhoneNumberRepository;
import com.jumia.customersinfo.service.PhoneNumberService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PhoneNumberServiceTest {

    @Autowired
    PhoneNumberService phoneNumberService;

    @Test
    void testGetPhoneNumbersWithPagination() {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(1L, "(212) 6007989253", "Morocco", "212", PhoneNumberState.NOT_VALID));
        phoneNumberList.add(new PhoneNumber(2L, "(212) 698054317", "Morocco", "212", PhoneNumberState.VALID));

        Page<PhoneNumber> phoneNumberPage = phoneNumberService.getPhoneNumbers(2, 0, null, null);
        Assert.assertArrayEquals(phoneNumberPage.toList().toArray(), phoneNumberList.toArray());
    }

    @Test
    void testGetPhoneNumbersWithStateFiltration() {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(2L, "(212) 698054317", "Morocco", "212", PhoneNumberState.VALID));
        phoneNumberList.add(new PhoneNumber(5L, "(212) 691933626", "Morocco", "212", PhoneNumberState.VALID));

        Page<PhoneNumber> phoneNumberPage = phoneNumberService.getPhoneNumbers(2, 0, null, "VALID");
        Assert.assertArrayEquals(phoneNumberPage.toList().toArray(), phoneNumberList.toArray());
    }

    @Test
    void testGetPhoneNumbersWithCountryFiltration() {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(32L, "(237) 697151594", "Cameroon", "237", PhoneNumberState.VALID));
        phoneNumberList.add(new PhoneNumber(33L, "(237) 677046616", "Cameroon", "237", PhoneNumberState.VALID));

        Page<PhoneNumber> phoneNumberPage = phoneNumberService.getPhoneNumbers(2, 0, "Cameroon", null);
        Assert.assertArrayEquals(phoneNumberPage.toList().toArray(), phoneNumberList.toArray());
    }

    @Test
    void testGetPhoneNumbersWithCountryAndStateFiltration() {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(16L, "(256) 775069443", "Uganda", "256", PhoneNumberState.VALID));
        phoneNumberList.add(new PhoneNumber(18L, "(256) 704244430", "Uganda", "256", PhoneNumberState.VALID));

        Page<PhoneNumber> phoneNumberPage = phoneNumberService.getPhoneNumbers(2, 0, "Uganda", "VALID");
        Assert.assertArrayEquals(phoneNumberPage.toList().toArray(), phoneNumberList.toArray());
    }

}
