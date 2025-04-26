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

    void modifyProductCnt(@Param("cartDetailsId") long cartDetailsId, @Param("productCnt") int productCnt);

    void delete(@Param("cartDetailsId") long cartDetailsId);
}
