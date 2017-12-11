package com.example.demo1.service;

import com.example.demo1.entity.Car;

import java.util.List;

public interface CarService {
    Car save(Car car);
    Car findById(String id);
    List<Car> findAll(int page, int size);
}
