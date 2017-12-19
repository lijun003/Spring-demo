package com.example.demo1.repository;

import com.example.demo1.entity.CarEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        CarEntity entity = new CarEntity();
        entity.setId("123");
        entity.setCarNum("A123456");
        testEntityManager.persist(entity);
    }

    @Test
    public void test_repository() throws Exception {

        CarEntity carEntity = carRepository.findOne("123");
        assertNotNull(carEntity);
        assertEquals("A123456", carEntity.getCarNum());

        List<CarEntity> entities = carRepository.findAll();
        assertNotNull(entities);
        assertEquals(1, entities.size());

    }
}