package com.bjtu.controller;

import com.bjtu.bean.User;
import com.bjtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(String username, String password, Model model) {
        String msg;

        if (userService.register(username, password)) {
            msg = "注册成功";
        } else {
            msg = "用户名已存在";
        }

        model.addAttribute("msg", msg);
        return "index";
    }

    @GetMapping("/login")
    public String login(String username, String password, Model model) {
        String msg;

        User user = userService.login(username, password);

        if (user == null) {
            msg = "登陆失败";
        } else if (user.getIsAdmin()) {
            msg = "管理员登录";
        } else {
            msg = "普通用户登录";
        }

        model.addAttribute("msg", msg);
        return "index";
    }

}
