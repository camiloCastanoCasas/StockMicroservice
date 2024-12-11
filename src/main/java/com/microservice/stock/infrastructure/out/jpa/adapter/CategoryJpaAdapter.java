package com.microservice.stock.infrastructure.out.jpa.adapter;

import com.microservice.stock.domain.model.Category;
import com.microservice.stock.domain.spi.ICategoryPersistencePort;
import com.microservice.stock.infrastructure.out.jpa.entity.CategoryEntity;
import com.microservice.stock.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.microservice.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        CategoryEntity categoryEntity = categoryEntityMapper.toCategoryEntity(category);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public boolean alreadyExistsByName(String name) {
        return categoryRepository.findByName(name).isPresent();
    }
}
