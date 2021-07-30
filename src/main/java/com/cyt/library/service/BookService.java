package com.cyt.library.service;

import com.cyt.library.bean.Book;
import com.cyt.library.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    public Book getBookById(int id){return bookDao.getBookById(id);}
    public Book getBookByName(String name){return bookDao.getBookByName(name);}
    public List<Book> getAllBook(){return bookDao.getAllBook();}
    public List<Book> searchBook(String keyword){return bookDao.searchBook("%"+keyword+"%");}
    public Boolean addBook(Book object){return bookDao.addBook(object);}
    public Boolean delBook(int id){return bookDao.delBook(id);}
    public Boolean upBook(Book object){return bookDao.upBook(object);}
}
