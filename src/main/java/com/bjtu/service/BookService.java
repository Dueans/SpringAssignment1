package com.bjtu.service;

import com.bjtu.bean.Book;
import com.bjtu.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getBooks(){
        return bookMapper.selectAll();
    }

    public Book getBookByID(Integer id){
        return bookMapper.selectByPrimaryKey(id);
    }

    public int saveBook(Book book){
        return bookMapper.insert(book);
    }

    public int updateBook(Book book){
        return bookMapper.updateByPrimaryKey(book);
    }

    public int deleteBook(Integer id){
        return bookMapper.deleteByPrimaryKey(id);
    }
}
