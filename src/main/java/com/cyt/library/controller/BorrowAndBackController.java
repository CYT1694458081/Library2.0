package com.cyt.library.controller;

import com.cyt.library.bean.*;
import com.cyt.library.domain.Res;
import com.cyt.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//用户借阅图书相关操作
@RestController
public class BorrowAndBackController {
    @Autowired
    private BorrowLogService borrowLogService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private DefaultRecordController defaultRecordController;
    //用户借书
    @RequestMapping("/public/borrowBook")
    public Res addBorrowLog(BorrowLog borrowLog){
        User user =userService.getUserById(borrowLog.getUser_id());
        if(user.getdRecord_num()>0) return new Res(Res.ERROR,"你当前有"+user.getdRecord_num()+"个罚单待处理，处理完成前无法借书！",null);
        else if(user.getBorrow_num()==3) return new Res(Res.ERROR,"你已达到借阅上限3本！",null);
        else{
            LocalDateTime time=LocalDateTime.now();
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String date = dtf2.format(time);
            borrowLog.setBorrow_date(date);
            Book book=bookService.getBookById(borrowLog.getBook_id());
//            System.out.println(borrowLog);
            if(book.getBook_num_now()>=1){
                user.setBorrow_num(user.getBorrow_num()+1);
                book.setBook_num_now(book.getBook_num_now()-1);
                if(userService.upUser(user)){
                    if(bookService.upBook(book)){
                        if(borrowLogService.addBorrowLog(borrowLog)){
                            return new Res(Res.SUCCESS,"借阅成功",null);
                        }
                        else return new Res(Res.FAILURE,"借阅失败，borrowLog添加失败",null);
                    }
                    else return new Res(Res.FAILURE,"借阅失败，book更新失败",null);
                }
                else return new Res(Res.FAILURE,"借阅失败,user更新失败",null);
            }
            else return new Res(Res.ERROR,"库存不足",null);
        }


    }

    public Res backbook(BorrowLog borrowLog,DateTimeFormatter dtf2,LocalDateTime backTime){
        String date = dtf2.format(backTime);
        User user=userService.getUserById(borrowLog.getUser_id());
        Book book=bookService.getBookById(borrowLog.getBook_id());
        user.setBorrow_num(user.getBorrow_num()-1);
        book.setBook_num_now(book.getBook_num_now()+1);
        borrowLog.setState("已还");
        borrowLog.setBack_date(date);
        if(borrowLogService.upBorrowLog(borrowLog)){
            if(userService.upUser(user)){
                if(bookService.upBook(book)){
                    return new Res(Res.SUCCESS,"归还成功",null);
                }
                else return new Res(Res.FAILURE,"归还失败,book更新失败",null);
            }
            else return new Res(Res.FAILURE,"归还失败,user更新失败",null);
        }
        else return new Res(Res.FAILURE,"归还失败,删除borrowLog失败",null);
    }
    //用户还书
    @RequestMapping("/public/backBook")
    public Res backBook(BorrowLog borrowLog){
        LocalDateTime backTime=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(borrowLog.getBorrow_date());
        LocalDateTime borrowTime = LocalDateTime.parse(borrowLog.getBorrow_date(),dtf2);
        Duration duration = Duration.between(borrowTime,backTime);
        long days = duration.toDays();
//        System.out.println(days);
        long timeOut = days-30;
        if( timeOut>0 ) {
            Res res=backbook(borrowLog,dtf2,backTime);
            if(res.getCode()==200){
                Res res2 =defaultRecordController.addDR("超时还书",borrowLog);
                if(res2.getCode()==200)
                    return new Res(Res.ERROR,"还书成功，超时"+timeOut+"天还书，罚单已生成，请前往‘我的待缴纳罚单’支付！（PS·在有罚单未支付的情况下无法借书）",null);
                else
                    return res2;
            }
            else return res;
        }
        else {
            return backbook(borrowLog,dtf2,backTime);
        }

    }
    //用户挂失书
    @RequestMapping("/public/loseBook")
    public Res loseBook(BorrowLog borrowLog){
        LocalDateTime backTime=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(backTime);
        Book book=bookService.getBookById(borrowLog.getBook_id());
        User user=userService.getUserById(borrowLog.getUser_id());
        book.setBook_num_all(book.getBook_num_all()-1);
        user.setBorrow_num(user.getBorrow_num()-1);
        borrowLog.setState("挂失");
        borrowLog.setBack_date(date);
        if(borrowLogService.upBorrowLog(borrowLog)){
            if(userService.upUser(user)){
                if(bookService.upBook(book)){
                    Res res2 =defaultRecordController.addDR("图书丢失",borrowLog);
                    if(res2.getCode()==200)
                        return new Res(Res.ERROR,"挂失成功，图书丢失罚单已生成，请前往‘我的罚单’支付！（PS·在有罚单未支付的情况下无法借书）",null);
                    else
                        return res2;
                }
                else return new Res(Res.FAILURE,"挂失失败,book更新失败",null);
            }
            else return new Res(Res.FAILURE,"挂失失败,user更新失败",null);
        }
        else return new Res(Res.FAILURE,"挂失失败,删除borrowLog失败",null);


    }
}
