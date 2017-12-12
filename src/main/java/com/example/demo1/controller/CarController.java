package com.example.demo1.controller;

import com.example.demo1.entity.Car;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface CarController {
    Car save(Car car);

    Car findById(String id);

    Car updateCarNumById(String id, String carNum);

    List<Car> findAll(int page, int size);

    void deleteById(String id);
}