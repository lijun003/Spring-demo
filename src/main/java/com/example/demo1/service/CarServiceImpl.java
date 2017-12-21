package com.example.demo1.service;

import com.example.demo1.domain.Filter;
import com.example.demo1.entity.CarEntity;
import com.example.demo1.entity.Color;
import com.example.demo1.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
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
    public CarEntity save(CarEntity carEntity) {
        return carRepository.save(carEntity);
    }

    @Override
    public void deleteById(String id) {
        carRepository.delete(id);
    }

    @Override public CarEntity updateCarNumById(String id, String carNum) throws NotFoundException {
        CarEntity carEntity = this.carRepository.findOne(id);
        if (null != carEntity) {
            carEntity.setCarNum(carNum);
            return carRepository.save(carEntity);
        } else {
            throw new NotFoundException(format("can not find carEntity by id: %s", id).getValue());
        }

    }

    @Override
    public CarEntity findById(String id) {
        log.info("find by id: {}", id);
        return carRepository.findOne(id);
    }

    @Override
    public List<CarEntity> findAll(int page, int size) {
        if (size > 0) {
            return carRepository.findAll(new PageRequest(page, size, new Sort(Sort.Direction.DESC, "id"))).getContent();
        } else {
            return carRepository.findAll();
        }
    }

    @Override public List<CarEntity> findAll(Filter filter) {
        Specification<CarEntity> specification = ((root, cq, cb) -> {
            Predicate predicate = cb.isNotNull(root.get("id"));
            String carNumKeyword = filter.getCarNumKeyword();
            if (StringUtils.isNotBlank(carNumKeyword)) {
                predicate= cb.and(predicate, cb.like(root.get("carNum"), "%" + carNumKeyword + "%"));
            }

            Color color = filter.getColor();
            if (null != color) {
                predicate = cb.and(predicate, cb.equal(root.get("color"), filter.getColor()));
            }

            return predicate;
        });
        int size = filter.getSize();
        int page = filter.getPage();
        if (size > 0) {
            return carRepository.findAll(specification, new PageRequest(page, size, new Sort(Sort.Direction.DESC, "id"))).getContent();
        }
        return carRepository.findAll(specification);
    }
}
