package com.example.charter.repository;

import com.example.charter.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    List<Order> getOrderByCustomerId(String customerId);
    Integer calRewardPoints(Integer total);
}
