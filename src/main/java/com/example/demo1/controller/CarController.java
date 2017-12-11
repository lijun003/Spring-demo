package com.example.demo1.controller;

import com.example.demo1.entity.Car;
import com.example.demo1.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/car", method = POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody Car save(@RequestBody Car car) {
        return carService.save(car);
    }

    @RequestMapping(value = "/car/{id}", method = GET)
    public @ResponseBody Car findById(@PathVariable String id) {
        return carService.findById(id);
    }

    @RequestMapping(value = "/car", method = GET)
    public @ResponseBody List<Car> findAll() {
        return carService.findAll();
    }
}