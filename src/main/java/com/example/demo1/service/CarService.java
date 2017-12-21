package com.example.demo1.service;

import com.example.demo1.domain.Filter;
import com.example.demo1.entity.CarEntity;

import javax.ws.rs.NotFoundException;
import java.util.List;

public interface CarService {
    CarEntity save(CarEntity carEntity);
    void deleteById(String id);
    CarEntity updateCarNumById(String id, String carNum) throws NotFoundException;
    CarEntity findById(String id);
    List<CarEntity> findAll(int page, int size);
    List<CarEntity> findAll(Filter filter);
}
