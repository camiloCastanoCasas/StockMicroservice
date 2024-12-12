package com.microservice.stock.application.dto.request;

import com.microservice.stock.application.constants.ApplicationConstants;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

    @NotBlank(message = ApplicationConstants.FIELD_NAME_NULL)
    @Size(max = ApplicationConstants.CATEGORY_NAME_MAX_VALUE, message = ApplicationConstants.CATEGORY_NAME_TOO_LONG)
    private String name;

    @NotBlank(message = ApplicationConstants.FIELD_DESCRIPTION_NULL)
    @Size(max = ApplicationConstants.CATEGORY_DESCRIPTION_MAX_VALUE, message = ApplicationConstants.CATEGORY_DESCRIPTION_TOO_LONG)
    private String description;
}
