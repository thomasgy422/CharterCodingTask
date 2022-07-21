package com.example.charter.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Integer calRewardPointsTotal(String customerId);
    Integer calRewardPointsByMonth(String customerId, String month);
}
