package com.bjtu.controller;

import com.bjtu.bean.User;
import com.bjtu.dao.UserMapper;
import com.bjtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String Hello(Model model){
//        userService
//        model.addAttribute("user",userMapper.selectByPrimaryKey(1));
        return "success";
    }
}
