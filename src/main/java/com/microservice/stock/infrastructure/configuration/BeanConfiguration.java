package com.microservice.stock.infrastructure.configuration;

import com.microservice.stock.domain.api.ICategoryServicePort;
import com.microservice.stock.domain.spi.ICategoryPersistencePort;
import com.microservice.stock.domain.usecase.CategoryUseCase;
import com.microservice.stock.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.microservice.stock.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.microservice.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }
}
