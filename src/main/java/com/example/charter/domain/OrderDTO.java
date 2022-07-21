package com.example.charter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String id;
    private String customerId;
    private String month;
    private int total;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomerId();
        this.month = order.getMonth();
        this.total = order.getTotal();
    }
}
