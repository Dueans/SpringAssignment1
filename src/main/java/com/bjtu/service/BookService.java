package com.bjtu.service;

import com.bjtu.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

}
