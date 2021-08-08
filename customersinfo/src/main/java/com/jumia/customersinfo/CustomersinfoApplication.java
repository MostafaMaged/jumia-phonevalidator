package com.jumia.customersinfo;

import com.jumia.customersinfo.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomersinfoApplication implements CommandLineRunner {

    @Autowired
    PhoneNumberService phoneNumberService;

    public static void main(String[] args) {
        SpringApplication.run(CustomersinfoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        phoneNumberService.initPhoneNumbersData();
    }
}
