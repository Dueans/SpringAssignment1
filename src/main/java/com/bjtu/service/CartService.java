package com.bjtu.service;

import com.bjtu.bean.Book;
import com.bjtu.bean.Cart;
import com.bjtu.dao.BookMapper;
import com.bjtu.dao.CartMapper;
import com.bjtu.vo.CartItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private BookMapper bookMapper;

    public List<CartItemVo> getCartItem(int user_id) {
        List<Cart> cartList = showAll(user_id);
        List<CartItemVo> cartItemVoList = new ArrayList<CartItemVo>();

        for (Cart cart : cartList) {
            Book book = bookMapper.selectByPrimaryKey(cart.getBookId());
            CartItemVo cartItemVo = new CartItemVo(cart.getBookId(), book.getTitle(), book.getPrice(), cart.getAmount());
            cartItemVoList.add(cartItemVo);
        }
        return cartItemVoList;
    }

    //将某书本加入购物车
    public boolean addTo(int userId, int bookId) {
        Cart cart = new Cart(userId, bookId, 1);
        return cartMapper.insert(cart) == 1;
    }

    //把购物车中某书本删除
    public boolean deleCart(int user_id, int book_id) {
        return cartMapper.deleteByPrimaryKey(user_id, book_id) == 1;
    }

    //购物车中某书本数量-1
    public void reduce(int user_id, int book_id) {
        Cart cart = cartMapper.selectByPrimaryKey(user_id, book_id);
        cart.setAmount(cart.getAmount()-1);
        cartMapper.updateByPrimaryKey(cart);
    }

    //购物车中某书本数量+1
    public void increase(int user_id, int book_id) {
        Cart cart = cartMapper.selectByPrimaryKey(user_id, book_id);
        cart.setAmount(cart.getAmount()+1);
        cartMapper.updateByPrimaryKey(cart);
    }

    //查看某用户的购物车
    public List<Cart> showAll(int userId) {
        return cartMapper.check(userId);
    }

    //得到书本单价
    public int getPrice(int bookId) {
        return cartMapper.getBookPrice(bookId);
    }

    //得到总金额
    public BigDecimal getTotal(int userId) {
        List<CartItemVo> cartItemVoList = getCartItem(userId);

        return getTotal(cartItemVoList);
    }

    public BigDecimal getTotal(List<CartItemVo> cartItemVoList) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItemVo cartItemVo : cartItemVoList) {
            totalPrice = totalPrice.add(cartItemVo.getBookPrice().multiply(new BigDecimal(cartItemVo.getAmount())));
        }
        return totalPrice;
    }

    public int clear(int userId){
        return cartMapper.deleteByUserId(userId);
    }

}
