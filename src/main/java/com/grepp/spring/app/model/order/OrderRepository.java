package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderRepository {
    void deleteOrderDetails(Long orderId);
    void deleteOrder(Long orderId);
    List<OrderDto> selectAll();
}