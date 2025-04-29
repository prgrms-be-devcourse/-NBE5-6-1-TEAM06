package com.grepp.spring.app.model.cart;

import com.grepp.spring.app.model.cart.dto.CartProduct;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CartRepository {

    List<CartProduct> findCartWithProductByUserId(@Param("userId") String userId);

    void modifyProductCnt(@Param("cartDetailsId") Long cartDetailsId,
        @Param("productCnt") int productCnt);

    void delete(@Param("cartDetailsId") Long cartDetailsId);

    CartProduct orderCartList(@Param("cartDetailsId") Long cartDetailsId);

    void order(@Param("cartDetailsId") Long cartDetailsId, @Param("address") String address,
        @Param("postNumber") String postNumber);


    void insertCartItem(String cartId, Long productId, Integer quantity);

    void createCart(@Param("userId") String userId);

    Long findCartIdByUserId(@Param("userId") String userId);

    void addOrderDetails(@Param("orderId") Long orderId, @Param("cartDetailsId") Long cartDetailsId);
}