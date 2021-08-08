package com.jumia.customersinfo.service;

import com.jumia.customersinfo.entity.enums.PhoneNumberState;
import com.jumia.customersinfo.entity.Country;
import com.jumia.customersinfo.entity.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CountryServiceImpl implements CountryService {

    private static Map<String, Country> countries = new HashMap();

    static {
        countries.put("237", new Country("Cameroon", "\\(237\\)\\s?[2368]\\d{7,8}$"));
        countries.put("251", new Country("Ethiopia", "\\(251\\)\\s?[1-59]\\d{8}$"));
        countries.put("212", new Country("Morocco", "\\(212\\)\\s?[5-9]\\d{8}$"));
        countries.put("258", new Country("Mozambique", "\\(258\\)\\s?[28]\\d{7,8}$"));
        countries.put("256", new Country("Uganda", "\\(256\\)\\s?\\d{9}$"));
    }

    @Override
    public PhoneNumber extractPhoneNumberInfo(String number) {
        PhoneNumber phoneNumber = new PhoneNumber();
        String countryCode = number.substring(number.indexOf("(") + 1, number.indexOf(")"));
        Country countryInfo = countries.get(countryCode);

        phoneNumber.setNumber(number);
        phoneNumber.setCode(countryCode);
        phoneNumber.setCountry(countryInfo.getName());
        phoneNumber.setState(validateNumber(number,
                countryInfo.getRegex()) ? PhoneNumberState.VALID : PhoneNumberState.NOT_VALID);

        return phoneNumber;
    }

    private Boolean validateNumber(String number, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
