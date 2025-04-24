package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    void deleteOrder(Long orderId);
}
