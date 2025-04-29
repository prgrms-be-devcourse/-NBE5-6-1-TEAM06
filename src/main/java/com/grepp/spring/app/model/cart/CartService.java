package com.grepp.spring.app.model.cart;

import com.grepp.spring.app.model.cart.dto.CartProduct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<CartProduct> getCartListByUserId(String userId) {
        return cartRepository.findCartWithProductByUserId(userId);
    }

    public void modifyProductCnt(Long cartDetailsId, int productCnt) {
        cartRepository.modifyProductCnt(cartDetailsId, productCnt);
    }

    public void delete(Long cartDetailsId) {
        cartRepository.delete(cartDetailsId);
    }

    public CartProduct orderCartList(Long cartDetailsId) {
        return cartRepository.orderCartList(cartDetailsId);
    }

    public void order(Long cartDetailsId, String address, String postNumber) {
        cartRepository.order(cartDetailsId, address, postNumber);
    }

    public void addItemsToCart(String userId, List<Long> productIds, List<Integer> quantities) {
        // 1. cart 존재하는지 확인
        Long cartId = cartRepository.findCartIdByUserId(userId);
        if (cartId == null) {
            cartRepository.createCart(userId); // 없으면 생성
            cartId = cartRepository.findCartIdByUserId(userId); // 다시 조회
        }

        // 2. cart_details 에 넣기
        if (productIds == null || quantities == null || productIds.size() != quantities.size()) {
            throw new IllegalArgumentException("상품 정보가 잘못됐어!");
        }

        for (int i = 0; i < productIds.size(); i++) {
            Long productId = productIds.get(i);
            Integer quantity = quantities.get(i);
            cartRepository.insertCartItem(String.valueOf(cartId), productId, quantity);
        }
    }

    public void addOrderDetails() {
        cartRepository.addOrderDetails();
    }
}