package com.example.demo1.controller;

import com.example.demo1.entity.Car;
import com.example.demo1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody public Car save(@RequestBody Car car){
        return carService.save(car);
    }

    @Override
    @RequestMapping(value = "/car/{id}", method = GET)
    @ResponseBody public Car findById(@PathVariable String id) {
        return carService.findById(id);
    }

    @Override
    @RequestMapping(value = "/car", method = PUT, consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    @ResponseBody public Car updateCarNumById(@RequestParam String id, @RequestParam String carNum) {

        return carService.updateCarNumById(id, carNum);
    }

    @Override
    @RequestMapping(value = "/car", method = GET)
    @ResponseBody public List<Car> findAll(@RequestParam int page, @RequestParam int size) {
        return carService.findAll(page, size);
    }

    @Override
    @RequestMapping(value = "/car/{id}", method = DELETE)
    @ResponseBody public void deleteById(@PathVariable String id) {
        carService.deleteById(id);
    }
}
