package com.bjtu.dao;

import com.bjtu.bean.Book;
import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    Book selectByPrimaryKey(Integer bookId);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);
}