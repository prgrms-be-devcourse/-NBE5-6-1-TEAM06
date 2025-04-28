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
}
