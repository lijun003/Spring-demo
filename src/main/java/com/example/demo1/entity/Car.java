package com.example.demo1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "car")
@Table(name = "car")
@Data
public class Car extends BaseEntity{
    @Column(name = "car_num")
    private String carNum;

}
