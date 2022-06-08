package com.pragma.api.image.application.configurations;

import com.pragma.api.image.domain.ports.IImageOutputPort;
import com.pragma.api.image.domain.usecase.ImageUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    @Value("${allowed.origin}")
    private String allowedOrigin;

    @Bean
    public WebMvcConfigurer getConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(allowedOrigin)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public ImageUseCase getImageService(IImageOutputPort iImageOutputPort) {
        return new ImageUseCase(iImageOutputPort);
    }

}
