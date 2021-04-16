package com.bjtu.dao;

import com.bjtu.bean.Cart;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    int insert(Cart record);

    Cart selectByPrimaryKey(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);
}