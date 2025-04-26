package com.grepp.spring.app.model.order;

import com.grepp.spring.app.controller.web.order.code.OrderStatus;
import com.grepp.spring.app.controller.web.order.form.OrderRequest;
import com.grepp.spring.app.controller.web.order.response.OrderResponse;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.order.dto.OrderDetailsDto;
import com.grepp.spring.app.model.order.dto.OrderDto;
import com.grepp.spring.app.model.product.ProductService;
import com.grepp.spring.app.model.product.dto.ProductDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        List<OrderDetailsDto> items;

        if (request.isFromCart()) {
            // 장바구니 기반 주문
            // 하드코딩으로 대체
            OrderDetailsDto item = new OrderDetailsDto();
            item.setProductCode("TEMP-001");
            item.setCategory("테스트 카테고리");
            item.setProductName("하드코딩 상품");
            item.setProductPrice(5000);
            item.setQuantity(2);
            item.setTotalPrice(5000 * 2);

            items = List.of(item);
            // 실제 서비스에서는 아래 코드 사용해야 함
//            items = cartService.getCartProductsByUserId(request.getUserId())
//                .stream()
//                .map(product -> OrderDetailsDto.builder()
//                    .productCode(product.getCode())
//                    .category(product.getCategory())
//                    .productName(product.getName())
//                    .unitPrice(product.getPrice())
//                    .quantity(product.getQuantity())
//                    .totalPrice(product.getPrice() * product.getQuantity())
//                    .build())
//                .toList();

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

                OrderDetailsDto item = new OrderDetailsDto();
                item.setProductCode(product.getCode());
                item.setCategory(product.getCategory());
                item.setProductName(product.getName());
                item.setProductPrice(product.getPrice());
                item.setQuantity(quantity);
                item.setTotalPrice(product.getPrice() * quantity);

                items.add(item);
            }
        }


        BigDecimal totalPrice = items.stream()
            .map(OrderDetailsDto::getTotalPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);


        LocalDateTime now = LocalDateTime.now();

        LocalDateTime expectedDeliveryDate;
        if (now.getHour() < 14) {
            // 14시 이전 주문 : 오늘 출고 +2일 도착 예상
            expectedDeliveryDate = now.plusDays(2);
        } else {
            // 14시 이후 주문 : 내일 출고 +3일 도착 예상
            expectedDeliveryDate = now.plusDays(3);
        }


        OrderResponse response = new OrderResponse();
        response.setUserName(request.getUserName());

        response.setOrderId(1001L);
        response.setUserId(request.getUserId());
        response.setMessage(request.getUserName() + "님 주문이 완료되었습니다!");
        response.setOrderStatus(OrderStatus.PAYMENT_COMPLETED);
        response.setTotalPrice(totalPrice);
        response.setOrderedAt(now);
        response.setExpectedDeliveryDate(expectedDeliveryDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (E)");
        String expectedDeliveryDateStr = expectedDeliveryDate.format(formatter);
        response.setExpectedDeliveryDateStr(expectedDeliveryDateStr);

        response.setItems(items);



        return response;
    }
}