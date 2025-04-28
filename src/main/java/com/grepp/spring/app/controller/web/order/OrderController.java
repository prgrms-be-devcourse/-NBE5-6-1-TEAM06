package com.grepp.spring.app.controller.web.order;

import com.grepp.spring.app.controller.web.cart.form.CartDetailsRequest;
import com.grepp.spring.app.controller.web.order.code.OrderStatus;
import com.grepp.spring.app.controller.web.order.form.OrderRequest;
import com.grepp.spring.app.controller.web.order.response.OrderResponse;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.cart.dto.CartProduct;
import com.grepp.spring.app.model.member.MemberService;
import com.grepp.spring.app.model.member.dto.Member;
import com.grepp.spring.app.model.order.OrderService;
import com.grepp.spring.app.model.order.dto.OrderDetailsDto;
import com.grepp.spring.app.model.product.ProductService;
import com.grepp.spring.app.model.product.dto.ProductDto;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private final ProductService productService;

    private final OrderService orderService;
    private final CartService cartService;

    private final MemberService memberService;

    @GetMapping
    public String showOrderPage(@ModelAttribute OrderRequest request, Model model,
        Principal principal) {

        String email = principal.getName();
        Member member = memberService.findById(email);
        model.addAttribute("member", member);

        request.setUserId(email);
        request.setUserName(member.getUserName());
        request.setTel(member.getTel()); // 회원 정보에 전화번호 있다면
        request.setAddress(member.getAddress()); // 주소도
        request.setPostNumber(member.getPostNumber());
        model.addAttribute("orderRequest", request);

        List<ProductDto> products = productService.getAllProducts();

        for (ProductDto p : products) {
            System.out.println("==============================");
            System.out.println("Product name: " + p.getProductName());
            System.out.println("Product imgUrl: " + p.getProductImgUrl());
        }

        model.addAttribute("products", products);

        return "/order/order";
    }

    @PostMapping
    public String handleOrder(
        @RequestParam("action") String action,
        @RequestParam("userName") String userName,
        @RequestParam("tel") String tel,
        @RequestParam("address") String address,
        @RequestParam("postNumber") String postNumber,
        @RequestParam("productIds") List<Long> productIds,
        @RequestParam("quantities") List<Integer> quantities,
        @ModelAttribute OrderRequest request,
        Model model, Principal principal) {

        //  0. 변수 선언
        List<OrderDetailsDto> items = new ArrayList<>();

        //  1. 상품 정보로 OrderDetailsDto 리스트 생성
        if (productIds != null && quantities != null && productIds.size() == quantities.size()) {
            for (int i = 0; i < productIds.size(); i++) {
                Long productId = productIds.get(i);
                Integer quantity = quantities.get(i);

                if (productId != null && quantity != null && quantity > 0) {
                    ProductDto product = productService.getProductById(productId);
                    if (product != null) {
                        OrderDetailsDto item = new OrderDetailsDto();
                        item.setProductId(productId);
                        item.setOrderCnt(quantity);
                        item.setProductPrice(
                            product.getPrice() != null ? product.getPrice().intValue() : 0
                        );
                        item.setCategory(
                            product.getCategory() != null ? product.getCategory() : "기타"
                        );
                        item.setProductName(
                            product.getProductName() != null ? product.getProductName() : "상품명없음"
                        );
                        item.setProductCode(
                            (product.getCode() != null && !product.getCode().isBlank())
                                ? product.getCode() : "없음"
                        );
                        item.setQuantity(quantity);
                        LocalDateTime now = LocalDateTime.now();
                        item.setOrderedAt(now); // 주문시간

                        LocalDateTime expectedDeliveryDate;
                        if (now.getHour() < 14) {
                            expectedDeliveryDate = now.plusDays(2);
                        } else {
                            expectedDeliveryDate = now.plusDays(3);
                        }
                        item.setExpectedDeliveryDate(expectedDeliveryDate); // 배송예정일

                        int unitPrice = item.getProductPrice() * quantity;
                        item.setUnitPrice(unitPrice);
                        item.setTotalPrice(BigDecimal.valueOf(unitPrice));

                        items.add(item);
                    }
                }
            }
        }

        //  2. request에 items 세팅
        request.setItems(items);

        //  3. 유저 정보 추가
        String email = principal.getName();
        request.setUserId(email);

        //  4. 주문 시간 및 배송 예정일 설정
        LocalDateTime now = LocalDateTime.now();
        request.setOrderedAt(now);
        request.setExpectedDeliveryDate(now.plusDays(3));

        //  5. 주문 상태 및 총 결제 금액 설정
        request.setOrderStatus(OrderStatus.PAYMENT_COMPLETED);

        BigDecimal totalPrice = items.stream()
            .map(OrderDetailsDto::getTotalPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        request.setTotalPrice(totalPrice);

        //  6. 콘솔 확인용
        System.out.println("Order Details Items: " + (items != null ? items.size() : "null"));

        //  7. 주문 종류에 따라 분기
        if (action.equals("cart")) {
            cartService.addItemsToCart(principal.getName(), productIds, quantities);
            return "redirect:/cartList";
        } else if (action.equals("order")) {

            // 1. order 저장
            orderService.createOrder(request);

            // 2. 생성된 orderId 꺼내기
            Long orderId = request.getOrderId();

            // 3. items에도 orderId 심기
            for (OrderDetailsDto item : items) {
                item.setOrderId(orderId);
            }

            // 4. orderDetails 저장
            if (!items.isEmpty()) {
                orderService.createOrderDetails(items);
            }

            // 5. 주문완료 페이지 이동
            OrderResponse response = orderService.createOrderResponse(request);
            model.addAttribute("order", response);

            return "/order/orderComplete";

        }

        return "redirect:/";
    }


    @GetMapping("cartOrderComplete")
    public String getCartOrderComplete() {
        return "order/cartOrderComplete";
    }

    @PostMapping("cartOrderComplete")

    public String postCartOrderComplete(
        @RequestParam String action,
        CartDetailsRequest cartDetailsRequest,
        @RequestParam("address") String address,
        @RequestParam("postNumber") String postNumber,
        Model model) {

        if ("cartListOrder".equals(action)) {
            CartProduct cartProduct = cartService.orderCartList(
                cartDetailsRequest.getCartDetailsId());
            model.addAttribute("cartProduct", cartProduct);

            cartService.order(cartDetailsRequest.getCartDetailsId(), address, postNumber);
            cartService.delete(cartDetailsRequest.getCartDetailsId());

            return "order/cartOrderComplete";
        }
        return "redirect:/orderList";
    }

    @PostMapping("/cart")
    public String addToCart(@ModelAttribute OrderRequest request, Principal principal) {
        String userId = principal.getName();
        cartService.addItemsToCart(userId, request.getProductIds(), request.getQuantities());
        return "redirect:/cartList";
    }

}
