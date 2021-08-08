package com.jumia.customersinfo.entity.enums;

public enum PhoneNumberState {
    VALID("VALID"),
    NOT_VALID("NOT_VALID");

    private String state;

    PhoneNumberState(String state) {
        this.state = state;
    }
}
