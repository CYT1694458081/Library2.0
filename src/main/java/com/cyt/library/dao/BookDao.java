package com.cyt.library.dao;

import com.cyt.library.bean.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BookDao {
    Book getBookById(int id);
    Book getBookByName(String name);
    List<Book> getAllBook();
    List<Book> searchBook(String keyword);
    Boolean addBook(Book object);
    Boolean delBook(int id);
    Boolean upBook(Book object);
}
