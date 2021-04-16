package com.bjtu.dao;

import com.bjtu.bean.OrderItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    int deleteByPrimaryKey(@Param("orderId") Integer orderId, @Param("bookId") Integer bookId);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(@Param("orderId") Integer orderId, @Param("bookId") Integer bookId);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem record);
}