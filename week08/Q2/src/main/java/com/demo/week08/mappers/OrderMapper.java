package com.demo.week08.mappers;

import org.springframework.stereotype.Repository;
import com.demo.week08.models.Order;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {

    void insertOne(Order order);
    void insertMany(List<Order> orders);
    void delete(Long id);
    void update(Order order);
    List<Map<String, Object>> query(Map<String, Object> condition);
}
