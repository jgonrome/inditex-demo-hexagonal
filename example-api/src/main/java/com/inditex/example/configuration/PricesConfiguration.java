package com.inditex.example.configuration;

import com.inditex.example.application.PricesService;
import com.inditex.example.domain.prices.PricesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PricesConfiguration {
    @Bean
    public PricesService pricesService(PricesRepository pricesRepository) {
        return new PricesService(pricesRepository);
    }
}
