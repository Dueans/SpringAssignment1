package com.bjtu.service;

import com.bjtu.bean.Book;
import com.bjtu.bean.Order;
import com.bjtu.bean.OrderItem;
import com.bjtu.dao.BookMapper;
import com.bjtu.dao.OrderItemMapper;
import com.bjtu.dao.OrderMapper;
import com.bjtu.vo.CartItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartService cartService;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    public String order(Order order) {
        //获取购物车中的物品
        List<CartItemVo> cartItems = cartService.getCartItem(order.getUserId());
        //检查剩余数量
        for (CartItemVo cartItemVo : cartItems) {
            Book book = bookMapper.selectByPrimaryKey(cartItemVo.getBookId());
            int leftAmount = book.getAmount();
            if (cartItemVo.getAmount() > leftAmount) {
                return book.getTitle();
            }
        }
        //插入
        orderMapper.insert(order);
        int orderId = orderMapper.selectOrderId(order);
        for (CartItemVo cartItem : cartItems) {
            Book book = bookMapper.selectByPrimaryKey(cartItem.getBookId());
            book.setAmount(book.getAmount() - cartItem.getAmount());
            bookMapper.updateByPrimaryKey(book);
            OrderItem orderItem = new OrderItem(orderId, book.getBookId(), cartItem.getAmount());
            orderItemMapper.insert(orderItem);
        }
        cartService.clear(order.getUserId());
        return "success";
    }

    public void viewOrder(Order order, Model model){
        List<Order> orderList = orderMapper.selectByUserId(order.getUserId());
        model.addAttribute("orderList",orderList);
        if (orderList.size()!=0){
            model.addAttribute("hasOrder",true);
        }else {
            model.addAttribute("hasOrder",false);
        }
    }

}
