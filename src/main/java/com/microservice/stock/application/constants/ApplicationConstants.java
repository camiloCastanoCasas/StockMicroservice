package com.microservice.stock.application.constants;

public final class ApplicationConstants {

    private ApplicationConstants(){
        throw new IllegalStateException("Utility class");
    }

    public static final String FIELD_NAME_NULL = "Field name cannot be null or empty.";
    public static final int CATEGORY_NAME_MAX_VALUE = 50;
    public static final String CATEGORY_NAME_TOO_LONG = "The name cannot exceed 50 characters.";
    public static final String FIELD_DESCRIPTION_NULL = "Field description cannot be null or empty.";
    public static final int CATEGORY_DESCRIPTION_MAX_VALUE = 90;
    public static final String CATEGORY_DESCRIPTION_TOO_LONG = "The description cannot exceed 90 characters.";

}
