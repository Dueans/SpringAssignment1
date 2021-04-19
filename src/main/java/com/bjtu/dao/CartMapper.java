package com.bjtu.dao;

import com.bjtu.bean.Cart;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    int insert(Cart record);

    Cart selectByPrimaryKey(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    List<Cart> selectAll();

    List<Cart> check(@Param("userId") Integer userId);

    int getBookPrice(@Param("bookId") Integer bookId);

    int updateByPrimaryKey(Cart record);

    int deleteByUserId(@Param("userId") Integer userId);
}