package com.grepp.spring.app.model.order;

import com.grepp.spring.app.model.order.dto.ASHOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ASHOrderRepository {

    List<ASHOrderDto> findOrderListByUserId(String userId);
    int cancelByOrderId(Long orderId);
    String findUserIdByOrderId(Long orderId);
    ASHOrderDto findOrderByOrderId(Long orderId);
}
