package com.grepp.spring.app.model.product.mapper;

import com.grepp.spring.app.model.product.dto.IndexProductDto;
import com.grepp.spring.app.model.product.dto.ProductDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {

    ProductDto findById(@Param("productId") Long productId);

    List<ProductDto> findAll();

    List<IndexProductDto> findAllProducts();

    void insert(ProductDto product);

    void update(ProductDto product);

    void delete(Long id);

    void updateStock(@Param("productId") Long productId, @Param("stock") int stock);


    List<ProductDto> adminFindAll();

}