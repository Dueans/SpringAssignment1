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
    UserService userService;

    @RequestMapping("/register")
    @GetMapping
    public String register(String username,String password, Model model) {

        String msg = "register ";

        if (userService.register(username,password)) {
            msg += "succeed";
        } else {
            msg += "fail";
        }

        model.addAttribute("msg", msg);
        return "success";
    }

    @RequestMapping("/login")
    @GetMapping
    public String login(String username, String password, Model model) {
        String msg = "login ";

        if (userService.login(username,password)) {
            msg += "succeed";
        } else {
            msg += "fail";
        }

        model.addAttribute("msg", msg);
        return "success";
    }


}
