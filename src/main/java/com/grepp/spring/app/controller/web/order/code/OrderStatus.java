package com.grepp.spring.app.controller.web.order.code;

import lombok.Getter;

@Getter
public enum OrderStatus {
   ORDER_REQUESTED("주문 요청"),
   ORDER_COMPLETED("주문 완료"),
   ORDER_CANCELED("주문 취소"),
   PAYMENT_PENDING("결제 대기"),
   PAYMENT_COMPLETED("결제 완료"),
   DELIVERY_PENDING("배송 대기"),
   DELIVERING("배송중"),
   DELIVERY_COMPLETED("배송 완료"),
   PAYMENT_REFUNDED("결제 환불");

   private final String label;

   OrderStatus(String label) {
       this.label = label;
   }

    @Override
    public String toString() {
        return label;
    }
}
