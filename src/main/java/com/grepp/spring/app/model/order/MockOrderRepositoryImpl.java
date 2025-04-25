package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.MockOrderItemDto;
import com.grepp.spring.app.model.order.dto.OrderDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class MockOrderRepositoryImpl implements OrderRepository {

    @Override
    public List<OrderDto> findOrdersByUserId(String userId) {
        List<OrderDto> mockList = new ArrayList<>();

        // 첫 번째 주문 아이템
        MockOrderItemDto item1 = new MockOrderItemDto();
        item1.setProductName("콜롬비아");
        item1.setOrderCnt(1);
        item1.setProductPrice(5000);

        MockOrderItemDto item2 = new MockOrderItemDto();
        item2.setProductName("에콰도르");
        item2.setOrderCnt(2);
        item2.setProductPrice(5000);

        // 첫 번째 주문
        OrderDto order1 = new OrderDto();
        order1.setOrderId(1001L);
        order1.setOrderedAt(LocalDateTime.now());
        order1.setExpectDeliveryAt(LocalDateTime.now());
        order1.setUserId(userId);
        order1.setTotalPrice(15000);

        //mock용 필드
        order1.setOrderDetails(List.of(item1, item2));

        mockList.add(order1);

        // 두 번째 주문 아이템
        MockOrderItemDto item3 = new MockOrderItemDto();
        item3.setProductName("에티오피아");
        item3.setOrderCnt(3);
        item3.setProductPrice(7000);

        // 두 번째 주문
        OrderDto order2 = new OrderDto();
        order2.setOrderId(1002L);
        order2.setUserId(userId);
        order2.setOrderedAt(LocalDateTime.now());
        order2.setExpectDeliveryAt(LocalDateTime.now());
        order2.setTotalPrice(21000);
        order2.setOrderDetails(List.of(item3));

        mockList.add(order2);

        return mockList;
    }

    @Override
    public int cancelOrderByOrderId(Long orderId) {
        return 0;
    }


    @Override
    public List<OrderDto> selectAll() {
        return List.of();
    }

}
