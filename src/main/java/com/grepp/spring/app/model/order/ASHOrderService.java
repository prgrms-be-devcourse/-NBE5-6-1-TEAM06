package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.ASHOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        ASHOrderDto order = ashOrderRepository.findOrderByOrderId(orderId);

        // 취소 실패 로직
        if (order == null
                ||
                order.getUserId().equals("test@email.com")
                // 로직 확인을 위한 하드코딩 상태
                // 비즈니스 로직 조건 고민 중 ~.~
        ) {
            return false;
        }
        // 취소 로직
        int updated = ashOrderRepository.cancelByOrderId(orderId);
        return updated > 0;
    }

    public String findUserIdById(Long orderId) {
        return ashOrderRepository.findUserIdByOrderId(orderId);
    }

    public ASHOrderDto getOrdersByOrderId(Long orderId) {
        return ashOrderRepository.findOrderByOrderId(orderId);
    }
}
