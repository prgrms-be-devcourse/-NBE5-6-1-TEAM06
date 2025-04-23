package com.grepp.spring.app.model.order;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    // note 화면 테스트용 더미 주문 객체입니다.
    // memberController에 하드코딩된 testUser의 정보를 볼 수 있습니다.
    // 전제: Member, Order, OrderDetail Dto의 생성자, 게터세터 있어야 함
    public List<OrderDto> getOrdersByUserId(String userId){
        List<OrderDto> mockList = new ArrayList<>();

        OrderDto order1 = new OrderDto();
        order1.setOrderId("0001");
        order1.setUserId(userId);
        order1.setTotalPrice(15000);

        OrderDetailDto prod1 = new OrderDetailDto("0001-1", "0001", "콜롬비아", 1, 5000);
        OrderDetailDto prod2 = new OrderDetailDto("0001-2", "0011", "에콰도르", 2, 5000);

        order1.setOrderDetails(List.of(prod1, prod2));
        mockList.add(order1);

        OrderDto order2 = new OrderDto();
        order2.setOrderId("0002");
        order2.setUserId(userId);
        order2.setTotalPrice(30000);

        OrderDetailDto prod3 = new OrderDetailDto("0002-1", "0001", "콜롬비아", 2, 10000);
        OrderDetailDto prod4 = new OrderDetailDto("0002-2", "0021", "에티오피아", 1, 5000);
        OrderDetailDto prod5 = new OrderDetailDto("0002-3", "0011", "에콰도르", 3, 15000);

        order2.setOrderDetails(List.of(prod3, prod4, prod5));
        mockList.add(order2);

        return mockList;
    }

}