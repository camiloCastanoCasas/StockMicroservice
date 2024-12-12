package com.microservice.stock.infrastructure.constants;

public final class DocumentationConstants {

    private DocumentationConstants(){
        throw new IllegalStateException("Utility Class");
    }

    public static final String TITTLE = "Stock Microservice";
    public static final String VERSION = "v1.0.0";
    public static final String DESCRIPTION = "Stock Microservice";
    public static final String TERMS_OF_SERVICE = "http://swagger.io/terms/";
    public static final String LICENSE_NAME = "Apache 2.0";
    public static final String LICENSE_URL = "http://springdoc.org";

    public static final String CREATED_STATUS_CODE = "201";
    public static final String BAD_REQUEST_STATUS_CODE = "400";
    public static final String CONFLICT_STATUS_CODE = "409";

    public static final String CATEGORY_TAG = "Category";
    public static final String CREATE_CATEGORY_SUMMARY = "Create category";
    public static final String CREATE_CATEGORY_DESCRIPTION = "This endpoint allows the creation of a new Category.";
    public static final String CREATED_CATEGORY_RESPONSE_CODE_DESCRIPTION = "Category created successfully.";
    public static final String BAD_REQUEST_CATEGORY_RESPONSE_CODE_DESCRIPTION = "Category not created.";
    public static final String CONFLICT_CATEGORY_RESPONSE_CODE_DESCRIPTION = "Category already exists.";


}
