package com.bjtu.controller;


import com.bjtu.bean.Book;
import com.bjtu.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/all")
    public String getBooks(Model model){
        model.addAttribute("books",bookService.getBooks());
        return "list";//需要修改
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getBookByID(@PathVariable Integer id, Model model){
        model.addAttribute("book",bookService.getBookByID(id));
        return "detail";//需要修改
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addBook(Book book,Model model){
        if (bookService.saveBook(book) == 0){
            model.addAttribute("result","false");
            return "addpage";//需要修改
        }
        else {
            model.addAttribute("result","success");
            return "redirect:/book/all";
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateBook(Book book,Model model){
        if (bookService.updateBook(book) == 0){
            model.addAttribute("result","false");
            return "updatepage";//需要修改
        }
        else {
            model.addAttribute("result","success");
            return "redirect:/book/all";
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String daleteBook(@PathVariable Integer id,Model model){
        if (bookService.deleteBook(id) == 0){
            model.addAttribute("result","false");
        }
        else {
            model.addAttribute("result","success");
        }
        return "redirect:/book/all";
    }


}
