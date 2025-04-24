package com.grepp.spring.app.model.order;

import com.grepp.spring.app.controller.web.order.code.OrderStatus;
import com.grepp.spring.app.controller.web.order.form.OrderRequest;
import com.grepp.spring.app.controller.web.order.response.OrderResponse;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.order.dto.OrderDto;
import com.grepp.spring.app.model.order.dto.OrderItemDto;
import com.grepp.spring.app.model.product.ProductService;
import com.grepp.spring.app.model.product.dto.ProductDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final ProductService productService;

    public List<OrderDto> selectAll() {
        return orderRepository.selectAll();
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAllOrders();
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteOrderDetails(orderId);
        orderRepository.deleteOrder(orderId);
    }


    public OrderResponse createOrder(OrderRequest request) {
        List<OrderItemDto> items;

        if (request.isFromCart()) {
            // 장바구니 기반 주문

            // 실제 서비스에서는 아래 코드 사용해야 함
//            items = cartService.getCartProductsByUserId(request.getUserId())
//                .stream()
//                .map(product -> OrderItemDto.builder()
//                    .productCode(product.getCode())
//                    .category(product.getCategory())
//                    .productName(product.getName())
//                    .unitPrice(product.getPrice())
//                    .quantity(product.getQuantity())
//                    .totalPrice(product.getPrice() * product.getQuantity())
//                    .build())
//                .toList();

            // 지금은 cartService 없음 → 하드코딩으로 대체
            items = List.of(
                OrderItemDto.builder()
                    .productCode("TEMP-001")
                    .category("테스트 카테고리")
                    .productName("하드코딩 상품")
                    .productPrice(5000)
                    .quantity(2)
                    .totalPrice(10000)
                    .build()
            );


        } else {
            if (request.getProductIds() == null || request.getQuantities() == null) {
                request.setProductIds(List.of(1L));
                request.setQuantities(List.of(2));
            }
            // 바로 구매
            items = new ArrayList<>();
            for (int i = 0; i < request.getProductIds().size(); i++) {
                Long productId = request.getProductIds().get(i);
                int quantity = request.getQuantities().get(i);

                ProductDto product = productService.getProduct(productId);

                items.add(OrderItemDto.builder()
                    .productCode(product.getCode())
                    .category(product.getCategory())
                    .productName(product.getName())
                    .productPrice(product.getPrice())
                    .quantity(quantity)
                    .totalPrice(product.getPrice() * quantity)
                    .build());
            }
        }

        int totalPrice = items.stream()
            .mapToInt(OrderItemDto::getTotalPrice)
            .sum();

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime expectDeliveryAt;
        if (now.getHour() < 14) {
            // 14시 이전 주문 : 오늘 출고 +2일 도착 예상
            expectDeliveryAt = now.plusDays(2);
        } else {
            // 14시 이후 주문 : 내일 출고 +3일 도착 예상
            expectDeliveryAt = now.plusDays(3);
        }

        return OrderResponse.builder()
            .orderId(1001L)
            .userId(request.getUserId())
            .message(request.getUserId() + "님 주문이 완료되었습니다 .ᐟ")
            .orderStatus(OrderStatus.PAYMENT_COMPLETED)
            .totalPrice(totalPrice)
            .orderDate(now)
            .expectDeliveryDate(expectDeliveryAt)
            .items(items)
            .build();
    }
}