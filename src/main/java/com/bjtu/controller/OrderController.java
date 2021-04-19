package com.bjtu.controller;

import com.bjtu.bean.Order;
import com.bjtu.bean.User;
import com.bjtu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderList")
    public String viewOrder(Order order, Model model) {
        orderService.viewOrder(order, model);
        return "order_list";
    }

    @ResponseBody
    @RequestMapping("/order")
    public String order(Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setCreatDate(new Date());
        order.setUserId(user.getUserId());
        System.out.println(order);
        return orderService.order(order);
    }
}
