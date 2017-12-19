package com.example.demo1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "car")
@Table(name = "car")
@Data
public class CarEntity extends BaseEntity<String>{
    @Column(name = "car_num")
    private String carNum;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color = Color.WHITE;

    @Override
    public void prePersist() {
        super.prePersist();
        if (null == getId()) {
            setId(UUID.randomUUID().toString());
        }
    }
}
