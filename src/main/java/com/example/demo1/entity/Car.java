package com.example.demo1.entity;

import liquibase.util.CollectionUtil;
import liquibase.util.StringUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "car")
@Table(name = "car")
@Data
public class Car {

    @Id
    @Column(name = "id", unique = true)
    private String id;
    @Column(name = "car_num")
    private String carNum;

    @PrePersist
    void prePersist() {
        if (StringUtils.isEmpty(id)) {
            setId(UUID.randomUUID().toString());
        }
    }
}
