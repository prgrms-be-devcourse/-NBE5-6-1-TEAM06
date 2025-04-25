package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.OrderDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {
    List<OrderDto> selectAll();

    List<OrderDto> findOrdersByUserId(String userId);

    int cancelOrderByOrderId(Long orderId);
}
