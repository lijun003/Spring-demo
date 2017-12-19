package com.example.demo1.controller;

import com.example.demo1.Filter;
import com.example.demo1.entity.CarEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface CarController {
    CarEntity save(CarEntity carEntity);

    CarEntity findById(String id);

    CarEntity updateCarNumById(String id, String carNum);

    List<CarEntity> findAll(int page, int size);

    List<CarEntity> findAll(Filter filter);

    void deleteById(String id);
}