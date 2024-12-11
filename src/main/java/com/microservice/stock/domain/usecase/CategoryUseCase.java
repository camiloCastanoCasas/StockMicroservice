package com.microservice.stock.domain.usecase;

import com.microservice.stock.domain.api.ICategoryServicePort;
import com.microservice.stock.domain.constants.DomainConstants;
import com.microservice.stock.domain.exceptions.AlreadyExistCategoryByName;
import com.microservice.stock.domain.model.Category;
import com.microservice.stock.domain.spi.ICategoryPersistencePort;

public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        if(categoryPersistencePort.alreadyExistsByName(category.getName())){
            throw new AlreadyExistCategoryByName(DomainConstants.CATEGORY_ALREADY_EXISTS);
        }
        categoryPersistencePort.saveCategory(category);
    }
}
