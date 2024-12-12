package com.microservice.stock.infrastructure.documentation;

import com.microservice.stock.infrastructure.constants.DocumentationConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(DocumentationConstants.TITTLE)
                        .version(DocumentationConstants.VERSION)
                        .description(DocumentationConstants.DESCRIPTION)
                        .termsOfService(DocumentationConstants.TERMS_OF_SERVICE)
                        .license(new License().name(DocumentationConstants.LICENSE_NAME).url(DocumentationConstants.LICENSE_URL))
                );
    }
}
