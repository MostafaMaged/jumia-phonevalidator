package com.jumia.customersinfo.entity;

import com.jumia.customersinfo.entity.enums.PhoneNumberState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "PHONE")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    private String country;

    private String code;

    @Enumerated(EnumType.STRING)
    private PhoneNumberState state;
}
