package com.springCourse.springBootcamp.Buyer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BuyerNotFoundException extends RuntimeException {

    public BuyerNotFoundException(String message) {
        super(message);
    }
}
