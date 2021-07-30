package com.cyt.library.controller;

import com.cyt.library.bean.Book;
import com.cyt.library.domain.Res;
import com.cyt.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
//对图书信息操作
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    //获取当前所有图书
    @RequestMapping("/public/getAllBook")
    public Res show(){
        List<Book> list=bookService.getAllBook();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //删除图书
    @RequestMapping("/public/delBook")
    public Res del(@RequestParam("del") int id){
        Book book = bookService.getBookById(id);
        if(book.getBook_num_now() != book.getBook_num_all()){
            return new Res(Res.ERROR,"该图书有未还记录，无法删除！",null);
        }
        else{
            if(bookService.delBook(id)){
                return new Res(Res.SUCCESS,"删除成功！",null);
            }else {
                return new Res(Res.ERROR,"删除失败！",null);
            }
        }

    }
    //添加图书
    public Res addBook(Book Book){
        if(bookService.getBookByName(Book.getName())!=null){
            return new Res(Res.FAILURE,"图书名已经存在！",null);
        }
        if(bookService.addBook(Book)){
            return new Res(Res.SUCCESS,"添加成功！",null);
        }else {
            return new Res(Res.ERROR,"添加失败！",null);
        }
    }

    //管理员添加图书
    @RequestMapping("/public/addBook")
    public Res ADMadd(Book Book){
        Res res=addBook(Book);
        return res;

    }
    //更新图书信息
    @RequestMapping("/public/upBook/")
    public Res up(Book new_book){
        Book old_book = bookService.getBookById(new_book.getBook_id());
        int borrw_num_old = old_book.getBook_num_all()-old_book.getBook_num_now();
        new_book.setBook_num_now(new_book.getBook_num_now()+new_book.getBook_num_all()-old_book.getBook_num_all());
        int borrw_num_now = new_book.getBook_num_all()-new_book.getBook_num_now();
        if(new_book.getBook_num_now()>=0 && borrw_num_now==borrw_num_old){
            if(bookService.upBook(new_book)){
                return new Res(Res.SUCCESS,"修改成功！",null);
            }
            else {
                return new Res(Res.ERROR,"修改失败！",null);
            }
        }
        else return new Res(Res.ERROR,"修改失败,该修改会导致在借书量变动！",null);

    }

    //模糊查找图书
    @RequestMapping("/public/searchBook")
    public Res select(@RequestParam("searchParam") String keyword){
        List<Book> list=bookService.searchBook(keyword);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据id获取对应图书信息
    @RequestMapping("/public/getBookById")
    public Res getById(@RequestParam("id") int id){
        Book Book =bookService.getBookById(id);
        return new Res(Res.SUCCESS,"查找成功",Book);
    }
}
