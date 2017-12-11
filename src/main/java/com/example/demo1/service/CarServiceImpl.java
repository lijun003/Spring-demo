package com.example.demo1.service;

import com.example.demo1.entity.Car;
import com.example.demo1.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findById(String id) {
        log.info("find by id: {}", id);
        return carRepository.findOne(id);
    }

    @Override
    public List<Car> findAll(int page, int size) {
        if (size > 0) {
            return carRepository.findAll(new PageRequest(page, size, new Sort(Sort.Direction.DESC, "id"))).getContent();
        } else {
            return carRepository.findAll();
        }
    }
}
