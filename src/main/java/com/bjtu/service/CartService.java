package com.bjtu.service;

import com.bjtu.bean.Cart;
import com.bjtu.dao.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired

    private CartMapper cartMapper;

    public boolean addTo(int user_id, int book_id, int amount){
        Cart cart = new Cart(user_id, book_id, amount);
        return cartMapper.insert(cart) == 1;
    }

    public boolean deleCart(int user_id, int book_id){
        return cartMapper.deleteByPrimaryKey(user_id, book_id) == 1;
    }

    public void reduce(int user_id, int book_id){
        int new_amount = cartMapper.selectByPrimaryKey(user_id, book_id).getAmount() - 1;
        cartMapper.selectByPrimaryKey(user_id, book_id).setAmount(new_amount) ;
    }

    public void increase(int user_id, int book_id){
        int new_amount = cartMapper.selectByPrimaryKey(user_id, book_id).getAmount() + 1;
        cartMapper.selectByPrimaryKey(user_id, book_id).setAmount(new_amount) ;
    }

    public void check(){cartMapper.selectAll();}

//    public int getTotal(int user_id){
//        return cartMapper.getTotal(user_id);
//    }


}
