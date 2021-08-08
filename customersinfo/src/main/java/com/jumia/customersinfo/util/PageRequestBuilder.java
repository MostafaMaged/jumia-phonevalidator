package com.jumia.customersinfo.util;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageRequestBuilder {

    public static PageRequest build(Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by("id").ascending();
        if(pageNumber == null) {
            pageNumber = 0;
        }
        if(pageSize == null) {
            pageSize = Integer.MAX_VALUE;
        }
        return PageRequest.of(pageNumber, pageSize, sort);
    }
}
