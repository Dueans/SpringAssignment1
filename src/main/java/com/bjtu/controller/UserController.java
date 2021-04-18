package com.bjtu.controller;

import com.bjtu.bean.Book;
import com.bjtu.bean.User;
import com.bjtu.service.BookService;
import com.bjtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("bookList",bookList);
        return "index";
    }

    @ResponseBody
    @PostMapping("/user/checkUsername")
    public String checkUsername(String username){
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
        return userService.login(user,httpSession);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:index";
    }

}
