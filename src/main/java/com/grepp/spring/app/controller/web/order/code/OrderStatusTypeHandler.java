package com.grepp.spring.app.controller.web.order.code;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getLabel()); // 저장할 때 label(한글)로 저장
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String label = rs.getString(columnName);
        return getOrderStatusByLabel(label);
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String label = rs.getString(columnIndex);
        return getOrderStatusByLabel(label);
    }

    @Override
    public OrderStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String label = cs.getString(columnIndex);
        return getOrderStatusByLabel(label);
    }

    private OrderStatus getOrderStatusByLabel(String label) {
        if (label == null) return null;
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getLabel().equals(label)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + label);
    }
}