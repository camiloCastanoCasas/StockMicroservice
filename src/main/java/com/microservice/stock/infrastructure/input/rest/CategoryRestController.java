package com.microservice.stock.infrastructure.input.rest;

import com.microservice.stock.application.dto.request.CreateCategoryRequest;
import com.microservice.stock.application.dto.response.GenericResponse;
import com.microservice.stock.application.handler.ICategoryHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController {

    private final ICategoryHandler categoryHandler;

    @PostMapping
    public GenericResponse createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        categoryHandler.createCategory(createCategoryRequest);
        return new GenericResponse("Category create successfully", HttpStatus.CREATED.toString(), LocalDateTime.now());
    }
}
