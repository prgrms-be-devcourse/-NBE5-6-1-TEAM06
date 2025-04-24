package com.grepp.spring.app.model.product.mapper;

import com.grepp.spring.app.model.product.dto.ProductDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {

    ProductDto findById(@Param("productId") Long productId);

    List<ProductDto> findAll();

    void insert(ProductDto product);

    void update(ProductDto product);

    void delete(Long id);
}