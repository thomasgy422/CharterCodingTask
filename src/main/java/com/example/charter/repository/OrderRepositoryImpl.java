package com.example.charter.repository;

import com.example.charter.domain.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private Map<String, Order> orderMap = new HashMap<>();

    @PostConstruct
    public void init() {
        Order order1 = new Order("1", "1", "1", 90);
        Order order2 = new Order("2", "1", "1", 80);
        Order order3 = new Order("3", "1", "1", 120);
        Order order4 = new Order("4", "1", "2", 80);
        Order order5 = new Order("5", "1", "2", 50);
        Order order6 = new Order("6", "1", "2", 80);
        Order order7 = new Order("7", "1", "3", 130);
        Order order8 = new Order("8", "1", "3", 150);
        Order order9 = new Order("9", "1", "3", 50);
        orderMap.put(order1.getId(), order1);
        orderMap.put(order2.getId(), order2);
        orderMap.put(order3.getId(), order3);
        orderMap.put(order4.getId(), order4);
        orderMap.put(order5.getId(), order5);
        orderMap.put(order6.getId(), order6);
        orderMap.put(order7.getId(), order7);
        orderMap.put(order8.getId(), order8);
        orderMap.put(order9.getId(), order9);
    }

    @Override
    public List<Order> getOrderByCustomerId(String customerId) {
        //loop through the orderMap, get order with customerId
        List<Order> ret = new ArrayList<>();
        for (String id: orderMap.keySet()) {
            if (orderMap.get(id).getCustomerId().equals(customerId)) {
                ret.add(orderMap.get(id));
            }
        }
        return ret;
    }

    @Override
    public Integer calRewardPoints(Integer total) {
        if (total >= 100) {
            return (total-100)*2 + 50;
        }
        else if (total >= 50) {
            return total - 50;
        }
        return 0;
    }
}
