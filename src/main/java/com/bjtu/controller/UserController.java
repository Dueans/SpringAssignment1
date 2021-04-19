package com.bjtu.controller;

import com.bjtu.bean.Book;
import com.bjtu.bean.Cart;
import com.bjtu.bean.User;
import com.bjtu.dao.BookMapper;
import com.bjtu.dao.CartMapper;
import com.bjtu.service.UserService;
import com.bjtu.vo.CartItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/user/checkUsername")
    public String checkUsername(String username) {
        return userService.checkUsername(username);
    }

    @ResponseBody
    @RequestMapping("/user/register")
    public String register(User user) {
        return userService.register(user);
    }

    @ResponseBody
    @RequestMapping("/user/login")
    public String login(User user, HttpSession httpSession) {
        return userService.login(user, httpSession);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:index";
    }

}
