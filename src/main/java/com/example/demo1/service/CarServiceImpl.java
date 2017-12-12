package com.example.demo1.service;

import com.example.demo1.entity.Car;
import com.example.demo1.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.ws.rs.NotFoundException;
import java.util.List;

import static com.sun.javafx.binding.StringFormatter.format;

@Slf4j
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
    public void deleteById(String id) {
        carRepository.delete(id);
    }

    @Override public Car updateCarNumById(String id, String carNum) throws NotFoundException {
        Car car = this.carRepository.findOne(id);
        if (null != car) {
            car.setCarNum(carNum);
            return carRepository.save(car);
        } else {
            throw new NotFoundException(format("can not find car by id: %s", id).getValue());
        }

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
