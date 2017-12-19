package com.example.demo1.config;

import com.example.demo1.controller.CarController;
import com.example.demo1.controller.CarControllerImpl;
import com.example.demo1.repository.CarRepository;
import com.example.demo1.service.CarService;
import com.example.demo1.service.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport
public class DependencyConfig {

    @Bean
    public CarService carService(CarRepository carRepository) {
        return new CarServiceImpl(carRepository);
    }

    @Bean
    public CarController carController(CarService carService) {
        return new CarControllerImpl(carService);
    }

}
