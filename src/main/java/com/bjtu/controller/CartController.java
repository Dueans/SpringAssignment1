package com.bjtu.controller;

import com.bjtu.bean.Book;
import com.bjtu.bean.Cart;
import com.bjtu.bean.User;
import com.bjtu.service.CartService;
import com.bjtu.vo.CartItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public String cartList(int userId, Model model, HttpSession session) {
        List<CartItemVo> cartItemVoList = cartService.getCartItem(userId);

        BigDecimal totalPrice = cartService.getTotal(cartItemVoList);

        model.addAttribute("cartItemVoList", cartItemVoList);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @ResponseBody
    @RequestMapping("/cart/add")
    public String addToCart(Cart cart, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            cartService.addTo(user.getUserId(), cart.getBookId());
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/cart/addOne")
    public String addOne(Cart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cartService.increase(user.getUserId(), cart.getBookId());
        return "success";
    }

    @ResponseBody
    @RequestMapping("/cart/removeOne")
    public String removeOne(Cart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cartService.reduce(user.getUserId(), cart.getBookId());
        return "success";
    }

    @ResponseBody
    @RequestMapping("/cart/remove")
    public String remove(Cart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cartService.deleCart(user.getUserId(),cart.getBookId());
        return "success";
    }
}
