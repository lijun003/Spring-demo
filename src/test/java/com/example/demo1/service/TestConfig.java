package com.example.demo1.service;

import com.example.demo1.repository.CarRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public CarRepository carRepository() {
        return Mockito.mock(CarRepository.class);
    }

}
