package com.microservice.stock.application.handler;

import com.microservice.stock.application.dto.request.CreateCategoryRequest;

public interface ICategoryHandler {
    void createCategory(CreateCategoryRequest createCategoryRequest);
}
