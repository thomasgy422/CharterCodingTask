package com.example.charter.service;

import com.example.charter.domain.Order;
import com.example.charter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Integer calRewardPointsTotal(String customerId) {
        Integer ans = 0;
        List<Order> orders = orderRepository.getOrderByCustomerId(customerId);
        for (Order order: orders) {
            ans += orderRepository.calRewardPoints(order.getTotal());
        }
        return ans;
    }

    @Override
    public Integer calRewardPointsByMonth(String customerId, String month) {
        Integer ans = 0;
        List<Order> orders = orderRepository.getOrderByCustomerId(customerId);
        for (Order order: orders) {
            if (order.getMonth().equals(month)){
                ans += orderRepository.calRewardPoints(order.getTotal());
            }
        }
        return ans;
    }
}
