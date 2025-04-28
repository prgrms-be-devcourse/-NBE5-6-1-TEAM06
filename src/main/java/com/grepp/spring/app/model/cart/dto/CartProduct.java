package com.grepp.spring.app.model.cart.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CartProduct")
public class CartProduct {
    private Long cartDetailsId;
    private Long cartId;
    private Long productId;
    private int productCnt;

    private String userId;

    private String productName;
    private int productPrice;
    private String category;

    // 추가
    private String userName;
    private LocalDate orderedAt = LocalDate.now(); // 주문일시
    private LocalDate expectedDeliveryAt; // 예상 배송일

    public CartProduct() {
        LocalDateTime now = LocalDateTime.now();
        LocalTime twoPM = LocalTime.of(14, 0); // 오후 2시

        // 전날 오후 2시
        LocalDateTime yesterdayTwoPM = now.minusDays(1).withHour(14).withMinute(0).withSecond(0).withNano(0);
        // 오늘 오후 2시
        LocalDateTime todayTwoPM = now.withHour(14).withMinute(0).withSecond(0).withNano(0);

        if (now.isAfter(yesterdayTwoPM) && now.isBefore(todayTwoPM)) {
            // 전날 오후 2시 이후부터 오늘 오후 2시 이전까지는 당일 배송
            this.expectedDeliveryAt = LocalDate.now();
        } else {
            // 그 외에는 내일 배송
            this.expectedDeliveryAt = LocalDate.now().plusDays(1);
        }
    }

}
