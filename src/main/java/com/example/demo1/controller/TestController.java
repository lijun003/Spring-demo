package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TestController {
    @RequestMapping(value = "/", method = GET)
    public String getMessage(){
        return "test message";
    }
}
