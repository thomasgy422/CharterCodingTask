package com.example.charter.controller;

import com.example.charter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {this.orderService = orderService;}

    @GetMapping("/calTotal/{customerId}")
    public ResponseEntity<Integer> calRewardPointsTotal(@PathVariable String customerId){
        return new ResponseEntity<>(orderService.calRewardPointsTotal(customerId), HttpStatus.OK);
    }

    @GetMapping("/calByMonth")
    public ResponseEntity<Integer> calRewardPointsByMonth(@RequestParam String customerId, @RequestParam String month) {
        return new ResponseEntity<>(orderService.calRewardPointsByMonth(customerId, month), HttpStatus.OK);
    }
}
