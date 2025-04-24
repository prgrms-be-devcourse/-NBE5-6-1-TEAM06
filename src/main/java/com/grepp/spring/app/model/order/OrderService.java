package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDto> selectAll() {
        return orderRepository.selectAll();
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAllOrders();
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteOrderDetails(orderId);
        orderRepository.deleteOrder(orderId);
    }

}
