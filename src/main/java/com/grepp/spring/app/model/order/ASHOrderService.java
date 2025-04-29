package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.ASHOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ASHOrderService {

    private final ASHOrderRepository ashOrderRepository;

    // DtoList 만드는 과정에서 포맷팅한 값도 넘겨줌
    public List<ASHOrderDto> getOrdersByUserId(String userId) {
        List<ASHOrderDto> orders = ashOrderRepository.findOrderListByUserId(userId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 mm분 ss초");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for(ASHOrderDto order : orders) {
            order.setFormattedOrderedAt(order.getOrderedAt().format(formatter));
            order.setFormattedExpectedDeliveryAt(order.getExpectedDeliveryDate().format(formatter2));
        }

        return orders;
    }

    // 취소 화면에 안 나와서 단 건 만드는 과정에서도 포맷팅한 값을 넘겨줌
    public ASHOrderDto getOrdersByOrderId(Long orderId) {
        ASHOrderDto order = ashOrderRepository.findOrderByOrderId(orderId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 mm분 ss초");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        order.setFormattedOrderedAt(order.getOrderedAt().format(formatter));
        order.setFormattedExpectedDeliveryAt(order.getExpectedDeliveryDate().format(formatter2));

        return order;
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
}
