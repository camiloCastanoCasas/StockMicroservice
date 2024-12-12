package com.microservice.stock.application.handler;

import com.microservice.stock.application.dto.request.CreateCategoryRequest;
import com.microservice.stock.application.mapper.ICategoryRequestMapper;
import com.microservice.stock.domain.api.ICategoryServicePort;
import com.microservice.stock.domain.model.Category;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler{

    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryServicePort categoryServicePort;

    @Override
    public void createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = categoryRequestMapper.toCategory(createCategoryRequest);
        categoryServicePort.createCategory(category);
    }
}
