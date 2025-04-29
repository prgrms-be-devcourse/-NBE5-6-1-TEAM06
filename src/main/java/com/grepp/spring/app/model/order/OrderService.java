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
import org.springframework.transaction.annotation.Transactional;

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
        return orderRepository.selectAll();
    }

    public List<OrderDto> getAllOrdersDetails() {
        return orderRepository.selectAllDetails();
    }

    public void cancelOrder(Long orderId) {
        orderRepository.cancelOrder(orderId);
    }


//    public void deleteOrder(Long orderId) {
//        orderRepository.deleteOrderDetails(orderId);
//        orderRepository.deleteOrder(orderId);
//    }

    public OrderResponse createOrder(OrderRequest request) {

        List<OrderDetailsDto> items;

        // 먼저 넘어온 orderId가 있으면 주문 상세에 세팅
        if (request.getOrderId() != null) {
            for (OrderDetailsDto item : request.getItems()) {
                item.setOrderId(request.getOrderId());
            }
        }

        // 장바구니 주문이면 cartService로부터 주문 상세 가져오기
        if (request.isFromCart()) {
            items = cartService.getCartListByUserId(request.getUserId())
                .stream()
                .map(cartProduct -> {
                    OrderDetailsDto item = new OrderDetailsDto();
                    item.setProductId(cartProduct.getProductId());
                    item.setProductName(cartProduct.getProductName());
                    item.setProductPrice(cartProduct.getProductPrice());
                    return item;
                }).toList();
        } else {
            // 아니면 productIds, quantities 직접 조합해서 주문 상세 생성
            if (request.getProductIds() == null || request.getQuantities() == null) {
                request.setProductIds(List.of(1L));
                request.setQuantities(List.of(2));
                log.info("요청받은 ProductIds: {}", request.getProductIds());
                log.info("요청받은 Quantities: {}", request.getQuantities());
            }

            items = new ArrayList<>();
            for (int i = 0; i < request.getProductIds().size(); i++) {
                Long productId = request.getProductIds().get(i);
                int quantity = request.getQuantities().get(i);

                ProductDto product = productService.getProduct(productId);
                log.info("조회된 상품: {}", product);

                OrderDetailsDto item = getOrderDetailsDto(product, quantity);
                items.add(item);
            }
        }

        // 총 금액 계산
        BigDecimal totalPrice = items.stream()
            .map(OrderDetailsDto::getTotalPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        LocalDateTime now = LocalDateTime.now();
        request.setOrderedAt(now);
        request.setExpectedDeliveryDate((now.getHour() < 14) ? now.plusDays(2) : now.plusDays(3));


        // 예상 배송일 계산
        LocalDateTime expectedDeliveryDate = (now.getHour() < 14) ? now.plusDays(2) : now.plusDays(3);

        // 주문 저장
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(request.getUserId());
        orderDto.setUserName(request.getUserName());
//        orderDto.setTotalPrice(request.getTotalPrice());
        orderDto.setTotalPrice(totalPrice);
        orderDto.setOrderedAt(now);
//        orderDto.setOrderedAt(request.getOrderedAt());
        orderDto.setExpectedDeliveryDate(request.getExpectedDeliveryDate());
        orderDto.setAddress(request.getAddress());
        orderDto.setPostNumber(request.getPostNumber());
        orderDto.setActivated(true);
        orderDto.setOrderStatus(request.getOrderStatus());

        orderRepository.insertOrder(orderDto);

        // 생성된 orderId 다시 세팅
        Long generatedOrderId = orderDto.getOrderId();
        request.setOrderId(generatedOrderId);

        // 주문 상세에 orderId 세팅 후 insert
        for (OrderDetailsDto item : request.getItems()) {
            item.setOrderId(generatedOrderId);
        }

        OrderResponse response = new OrderResponse();
        response.setUserName(request.getUserName());
        response.setOrderId(generatedOrderId);
        response.setUserId(request.getUserId());
        response.setMessage(request.getUserName() + "님 주문이 완료되었습니다!");
        response.setOrderStatus(OrderStatus.PAYMENT_COMPLETED);
        response.setTotalPrice(totalPrice);
        response.setOrderedAtStr(request.getOrderedAtStr());
        response.setAddress(request.getAddress());
        response.setPostNumber(request.getPostNumber());
        response.setTel(request.getTel());
        response.setOrderedAt(now); // request.getOrderedAt()말고 now
//        response.setOrderedAt(request.getOrderedAt());
        response.setExpectedDeliveryDate(expectedDeliveryDate);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (E)");

        String expectedDeliveryDateStr = expectedDeliveryDate.format(formatter);
        response.setExpectedDeliveryDateStr(expectedDeliveryDateStr);

        String orderedAtStr = now.format(formatter);
        response.setOrderedAtStr(orderedAtStr);

        response.setItems(items);

        if (!items.isEmpty()) {
            OrderDetailsDto firstItem = items.get(0);
            response.setProductName(firstItem.getProductName());
            response.setProductPrice(firstItem.getProductPrice());
            response.setQuantity(firstItem.getQuantity());
            response.setUnitPrice(firstItem.getUnitPrice());
            response.setProductCode(firstItem.getProductCode());
            response.setCategory(firstItem.getCategory());
        }


        return response;
    }



    // 상품 정보를 OrderDetailsDto로 변환하는 유틸 메서드
    public static OrderDetailsDto getOrderDetailsDto(ProductDto product, int quantity) {
        OrderDetailsDto item = new OrderDetailsDto();

        // ProductId (Long) - null이면 그냥 넘겨
        item.setProductId(product.getProductId());

        // ProductPrice (BigDecimal -> int) - null이면 0원
        BigDecimal price = product.getPrice() != null ? product.getPrice() : BigDecimal.ZERO;
        item.setProductPrice(price.intValue());

        // Category (String) - null이면 "기타"
        item.setCategory(product.getCategory() != null ? product.getCategory() : "기타");

        // ProductName (String) - null이면 "상품명없음"
        item.setProductName(product.getProductName() != null ? product.getProductName() : "상품명없음");

        // ProductCode (String) - null이면 "없음"
        item.setProductCode(
            (product.getCode() != null && !product.getCode().isBlank())
                ? product.getCode()
                : "상품코드없음"
        );
        // Quantity (int) - 넘어오는 quantity 그대로
        item.setQuantity(quantity);

        // UnitPrice (int) = 단가 * 수량
        int unitPrice = price.intValue() * quantity;
        item.setUnitPrice(unitPrice);

        // TotalPrice (BigDecimal) = 단가 * 수량
        item.setTotalPrice(BigDecimal.valueOf(unitPrice));

        return item;
    }

    @Transactional
    public void createOrderDetails(List<OrderDetailsDto> items) {
        if (items != null && !items.isEmpty()) {
            for (OrderDetailsDto item : items) {
                orderRepository.insertOrderDetail(item);
            }
        }
    }

    public void insertOrderDetails(List<OrderDetailsDto> items) {
        if (items != null && !items.isEmpty()) {
            orderRepository.insertOrderDetails(items);
        } else {
            System.out.println("Order details list is empty or null. Skipping insert.");
        }
    }

    public OrderResponse createOrderResponse(OrderRequest request) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(request.getOrderId());
        response.setOrderStatus(request.getOrderStatus());
        response.setExpectedDeliveryDateStr(request.getExpectedDeliveryDateStr());
        response.setItems(request.getItems());
        return response;
    }


}