package com.microservice.stock.domain.exceptions;

public class AlreadyExistCategoryByName extends RuntimeException {
    public AlreadyExistCategoryByName(String message) {
        super(message);
    }
}
