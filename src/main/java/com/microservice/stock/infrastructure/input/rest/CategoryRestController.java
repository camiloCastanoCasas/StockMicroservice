package com.microservice.stock.infrastructure.input.rest;

import com.microservice.stock.application.dto.request.CreateCategoryRequest;
import com.microservice.stock.application.dto.response.GenericResponse;
import com.microservice.stock.application.handler.ICategoryHandler;
import com.microservice.stock.infrastructure.constants.DocumentationConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = DocumentationConstants.CREATE_CATEGORY_SUMMARY,
            tags = {DocumentationConstants.CATEGORY_TAG},
            description = DocumentationConstants.CREATE_CATEGORY_DESCRIPTION
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = DocumentationConstants.CREATED_STATUS_CODE,
                    description = DocumentationConstants.CREATED_CATEGORY_RESPONSE_CODE_DESCRIPTION,
                    content = @Content),
            @ApiResponse(responseCode = DocumentationConstants.BAD_REQUEST_STATUS_CODE,
                    description = DocumentationConstants.BAD_REQUEST_CATEGORY_RESPONSE_CODE_DESCRIPTION,
                    content = @Content),
            @ApiResponse(responseCode = DocumentationConstants.CONFLICT_STATUS_CODE,
                    description = DocumentationConstants.CONFLICT_CATEGORY_RESPONSE_CODE_DESCRIPTION,
                    content = @Content),
    })
    @PostMapping
    public GenericResponse createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        categoryHandler.createCategory(createCategoryRequest);
        return new GenericResponse(DocumentationConstants.CREATED_CATEGORY_RESPONSE_CODE_DESCRIPTION, HttpStatus.CREATED.toString(), LocalDateTime.now());
    }
}
