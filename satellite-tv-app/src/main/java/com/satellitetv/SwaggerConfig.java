package com.satellitetv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig
{
    @Bean
    public Docket channels()
    {
        return new Docket(DocumentationType.SWAGGER_2).select().
                apis(RequestHandlerSelectors.basePackage("com.satellitetv.controllers.ChannelController")).paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket packages()
    {
        return new Docket(DocumentationType.SWAGGER_2).select().
                apis(RequestHandlerSelectors.basePackage("com.satellitetv.controllers.PackageController")).paths(PathSelectors.any()).build();
    }
}
