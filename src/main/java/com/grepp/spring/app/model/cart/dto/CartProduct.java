package com.grepp.spring.app.model.cart.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private String userName;
    private LocalDate orderedAt = LocalDate.now(); // 주문일시
    private LocalDate expectDeliveriedAt; // 예상 배송일

    public CartProduct() {
        LocalDateTime now = LocalDateTime.now();
        // 전날 오후 2시
        LocalDateTime yesterdayTwoPM = now.minusDays(1).withHour(14).withMinute(0).withSecond(0);
        // 오늘 오후 2시
        LocalDateTime todayTwoPM = now.withHour(14).withMinute(0).withSecond(0);

        if (now.isAfter(yesterdayTwoPM) && now.isBefore(todayTwoPM)) {
            // 전날 오후 2시 이후부터 오늘 오후 2시 이전까지는 2일 후 배송
            this.expectDeliveriedAt = LocalDate.now().plusDays(2);
        } else {
            // 그 외에는 3일 후 배송
            this.expectDeliveriedAt = LocalDate.now().plusDays(3);
        }
    }

}
