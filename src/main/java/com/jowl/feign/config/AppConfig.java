package com.jowl.feign.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Contract useFeignAnnotations() {
        return new Contract.Default();
    }
}
