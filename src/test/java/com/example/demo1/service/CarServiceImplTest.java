package com.example.demo1.service;

import com.example.demo1.config.DependencyConfig;
import com.example.demo1.entity.CarEntity;
import com.example.demo1.repository.CarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@Import({ TestConfig.class, DependencyConfig.class})
public class CarServiceImplTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carServiceImpl;

    @Test
    public void test_save() throws Exception {
        CarEntity carEntity = new CarEntity();
        carEntity.setId("123");
        when(carRepository.save(carEntity)).thenReturn(carEntity);
        CarEntity entity = carServiceImpl.save(carEntity);
        verify(carRepository, times(1)).save(any(CarEntity.class));
        Assert.assertEquals("123", entity.getId());
    }


}