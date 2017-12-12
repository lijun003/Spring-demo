package com.example.demo1.service;

import com.example.demo1.entity.Car;

import javax.ws.rs.NotFoundException;
import java.util.List;

public interface CarService {
    Car save(Car car);
    void deleteById(String id);
    Car updateCarNumById(String id, String carNum) throws NotFoundException;
    Car findById(String id);
    List<Car> findAll(int page, int size);
}
