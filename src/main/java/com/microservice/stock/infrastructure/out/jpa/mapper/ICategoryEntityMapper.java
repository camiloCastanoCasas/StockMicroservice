package com.microservice.stock.infrastructure.out.jpa.mapper;

import com.microservice.stock.domain.model.Category;
import com.microservice.stock.infrastructure.out.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {
    CategoryEntity toCategoryEntity(Category category);
}
