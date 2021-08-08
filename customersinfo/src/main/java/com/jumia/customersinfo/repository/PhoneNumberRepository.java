package com.jumia.customersinfo.repository;

import com.jumia.customersinfo.entity.PhoneNumber;
import com.jumia.customersinfo.entity.enums.PhoneNumberState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    Page<PhoneNumber> findByCountry(String country, Pageable pageRequest);

    Page<PhoneNumber> findByState(PhoneNumberState state, Pageable pageable);

    Page<PhoneNumber> findByStateAndCountry(PhoneNumberState state, String country, Pageable pageable);
}
