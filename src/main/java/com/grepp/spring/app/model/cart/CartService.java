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

    public void modifyProductCnt(long cartDetailsId, int productCnt) {
        cartRepository.modifyProductCnt(cartDetailsId, productCnt);
    }

    public void delete(long cartDetailsId) {
        cartRepository.delete(cartDetailsId);
    }
}
