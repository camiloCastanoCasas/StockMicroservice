package com.microservice.stock.domain.constants;

public final class DomainConstants {

    private DomainConstants(){
        throw new IllegalStateException("Utility class");
    }

    public static final String CATEGORY_ALREADY_EXISTS = "The category already exists with that name.";
}
