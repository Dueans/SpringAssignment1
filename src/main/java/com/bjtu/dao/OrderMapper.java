package com.bjtu.dao;

import com.bjtu.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    int selectOrderId(Order order);

    List<Order> selectByUserId(Integer userId);
}