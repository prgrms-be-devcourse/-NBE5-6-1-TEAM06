package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.ASHOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ASHOrderService {

    private final ASHOrderRepository ashOrderRepository;

    public List<ASHOrderDto> getOrdersByUserId(String userId) {
        return ashOrderRepository.findOrderListByUserId(userId);

    }

    @Transactional
    public boolean cancelOrder(Long orderId) {
        return ashOrderRepository.cancelByOrderId(orderId) > 0;
    }
}
