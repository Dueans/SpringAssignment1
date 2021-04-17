package com.bjtu.controller;

import com.bjtu.bean.User;
import com.bjtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {return "index";}

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
            return "";
        }

        model.addAttribute("user", user);
        return "index";
    }

}
