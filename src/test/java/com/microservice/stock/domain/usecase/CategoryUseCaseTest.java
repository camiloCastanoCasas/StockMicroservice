package com.microservice.stock.domain.usecase;

import com.microservice.stock.domain.constants.DomainConstants;
import com.microservice.stock.domain.exceptions.AlreadyExistCategoryByName;
import com.microservice.stock.domain.model.Category;
import com.microservice.stock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Test
    @DisplayName("Inserts a Category in the DB")
    void createCategory() {
        Category category = new Category(1L, "CategoryName", "CategoryDescription");
        Mockito.when(categoryPersistencePort.alreadyExistsByName("CategoryName")).thenReturn(false);
        categoryUseCase.createCategory(category);
        Mockito.verify(categoryPersistencePort, Mockito.times(1)).saveCategory(category);
        Mockito.verify(categoryPersistencePort, Mockito.times(1)).alreadyExistsByName("CategoryName");
    }

    @Test
    @DisplayName("Validation exception when category already exists by name in the DB")
    void createCategoryShouldThrowValidationExceptionWhenCategoryAlreadyExistsByName(){
        Category category = new Category(1L, "CategoryName", "CategoryDescription");
        Mockito.when(categoryPersistencePort.alreadyExistsByName("CategoryName")).thenReturn(true);
        AlreadyExistCategoryByName exception = assertThrows(AlreadyExistCategoryByName.class, () -> {
            categoryUseCase.createCategory(category);
        });
        assertThat(exception.getMessage()).isEqualTo(DomainConstants.CATEGORY_ALREADY_EXISTS);
        Mockito.verify(categoryPersistencePort, Mockito.never()).saveCategory(category);
        Mockito.verify(categoryPersistencePort, Mockito.times(1)).alreadyExistsByName("CategoryName");
    }
}