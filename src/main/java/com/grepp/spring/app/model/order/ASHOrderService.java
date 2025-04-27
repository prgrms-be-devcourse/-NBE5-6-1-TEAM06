package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.ASHOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ASHOrderService {

    private final ASHOrderRepository ashOrderRepository;

    public List<ASHOrderDto> getOrdersByUserId(String userId) {
        return ashOrderRepository.findOrderListByUserId(userId);

    }

    // 와 이거 너무 코드가............
    @Transactional
    public boolean cancelOrder(Long orderId) {
        ASHOrderDto order = ashOrderRepository.findOrderByOrderId(orderId);

        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        // 오늘, 어제 14시
        LocalDateTime todayTwoPM = today.atTime(14, 0);
        LocalDateTime yesterdayTwoPM = today.minusDays(1).atTime(14, 0);

        LocalDateTime orderedAt = order.getOrderedAt();

        boolean canCancel;

        //행위 시점이 오늘 2시 이전이라면?
        if(now.isBefore(todayTwoPM)){
            // 전날 2시 이후 주문부터 취소 가능
            canCancel = orderedAt.isAfter(yesterdayTwoPM);
        } else {
            // 오늘 2시 이전이 아니라면?(== 이후라면?)
            // 오늘 2시 이후 주문부터 취소 가능
            canCancel = orderedAt.isAfter(todayTwoPM);
        }

        // 취소 실패
        if (!canCancel) {
            return false;
        }

        // 취소 update
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
