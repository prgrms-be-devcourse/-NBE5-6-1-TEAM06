package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.OrderDto;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MockOrderRepositoryImpl mockOrderRepository;

    public List<OrderDto> selectAll() {
        return orderRepository.selectAll();
    }


    public List<OrderDto> getOrdersByUserId(String userId) {
        return orderRepository.findOrdersByUserId(userId);

    }

    // todo cancel 검증 : 지금은 항상 실패로 연결
    public boolean cancelOrder(Long orderId) {
        int updated = orderRepository.cancelOrderByOrderId(orderId);
        return updated > 0;
    }
}
