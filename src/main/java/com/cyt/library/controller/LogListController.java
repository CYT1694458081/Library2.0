package com.cyt.library.controller;

import com.cyt.library.bean.LogList;
import com.cyt.library.domain.Res;
import com.cyt.library.service.LogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//按各种要求查找显示借阅记录
@RestController
public class LogListController {
    @Autowired
    private LogListService logListService;
    //获取所有借阅记录
    @RequestMapping("/public/getAllBorrowList")
    public Res getAllBorrowList(){
        List<LogList> list=logListService.getAllBorrowList();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //获取对应用户所有借阅记录
    @RequestMapping("/public/getAllBorrowListByName")
    public Res getAllBorrowListByName(@RequestParam("name") String name){
        List<LogList> list=logListService.getBorrowListByName(name);
        return new Res(Res.SUCCESS,"查找成功",list);
    }

    //查找对应用户的在借的记录
    @RequestMapping("/public/getNowBorrowListByName")
    public Res getNowBorrowListByName(@RequestParam("name") String name){
        List<LogList> list=logListService.getBorrowListByNameAndState(name,"在借");
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //查找对应用户的归还的记录
    @RequestMapping("/public/getBackListByName")
    public Res getBackListByName(@RequestParam("name") String name){
        List<LogList> list=logListService.getBorrowListByNameAndState(name,"已还");
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名,状态和用户名模糊查找借阅记录
    @RequestMapping("/public/getBorrowListByKey")
    public Res getBorrowListByKey(@RequestParam("key") String key){
        List<LogList> list=logListService.getBorrowListByKey(key);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名和状态模糊查找对应用户所有的借阅记录
    @RequestMapping("/public/searchAllUserBorrowListByKey")
    public Res searchAllUserBorrowListByKey(@RequestParam("user") String user,@RequestParam("key") String key){
        List<LogList> list=logListService.searchUserBorrowListByKey(user, key);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名模糊查找对应用户在借的记录
    @RequestMapping("/public/searchNowUserBorrowListByBook")
    public Res searchNowUserBorrowListByBook(@RequestParam("user") String user,@RequestParam("book") String book){
        List<LogList> list=logListService.searchNowUserBorrowListByBook(user, book);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名模糊查找对应用户的归还记录
    @RequestMapping("/public/searchUserBackListByBook")
    public Res searchUserBackListByBook(@RequestParam("user") String user,@RequestParam("book") String book){
        List<LogList> list=logListService.searchUserBackListByBook(user, book);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
}
