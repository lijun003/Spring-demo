package com.example.demo1.controller;

import com.example.demo1.Filter;
import com.example.demo1.entity.CarEntity;
import com.example.demo1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

public class CarControllerImpl implements CarController{
    private CarService carService;

    @Autowired
    public CarControllerImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    @RequestMapping(value = "/car", method = POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public CarEntity save(@RequestBody CarEntity carEntity){
        return carService.save(carEntity);
    }

    @Override
    @RequestMapping(value = "/car/{id}", method = GET)
    public CarEntity findById(@PathVariable String id) {
        return carService.findById(id);
    }

    @Override
    @RequestMapping(value = "/car", method = PUT, consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public CarEntity updateCarNumById(@RequestParam String id, @RequestParam String carNum) {

        return carService.updateCarNumById(id, carNum);
    }

    @Override
    @RequestMapping(value = "/car", method = GET)
    public List<CarEntity> findAll(@RequestParam int page, @RequestParam int size) {
        return carService.findAll(page, size);
    }
    @Override
    @RequestMapping(value = "/car", method = POST)
    public List<CarEntity> findAll(@RequestBody Filter filter) {
        return carService.findAll(filter);
    }

    @Override
    @RequestMapping(value = "/car/{id}", method = DELETE)
    public void deleteById(@PathVariable String id) {
        carService.deleteById(id);
    }
}
