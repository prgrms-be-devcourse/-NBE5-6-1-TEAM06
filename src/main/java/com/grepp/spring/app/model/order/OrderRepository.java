package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.OrderDetailsDto;
import com.grepp.spring.app.model.order.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderRepository {
    List<OrderDto> findAllOrders();
    void deleteOrderDetails(Long orderId);
    void deleteOrder(Long orderId);
    List<OrderDto> selectAll();
    void insertOrder(OrderDto order);

    void insertOrderDetails(List<OrderDetailsDto> items);

    void insertOrderDetail(OrderDetailsDto item);
}
