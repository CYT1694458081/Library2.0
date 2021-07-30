package com.cyt.library.controller;

import com.cyt.library.bean.BorrowLog;
import com.cyt.library.bean.DRecordList;
import com.cyt.library.bean.DefaultRecord;
import com.cyt.library.bean.User;
import com.cyt.library.domain.Res;
import com.cyt.library.service.DRecordListService;
import com.cyt.library.service.DefaultRecordService;
import com.cyt.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//罚单对应操作
@RestController
public class DefaultRecordController {
    @Autowired
    private DRecordListService dRecordListService;
    @Autowired
    private DefaultRecordService defaultRecordService;
    @Autowired
    private UserService userService;
    //获取所有的罚款记录
    @RequestMapping("/public/getAllDRList")
    public Res getAllBDRList(){
        List<DRecordList> list=dRecordListService.getAllDRList();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //查找对应用户的罚款历史
    @RequestMapping("/public/getDRListByName")
    public Res getDRListByName(@RequestParam("name") String name){
        List<DRecordList> list=dRecordListService.getDRListByName(name);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //查找对应用户的未缴纳罚款
    @RequestMapping("/public/getNowDRListByName")
    public Res getNowDRListByName(@RequestParam("name") String name){
        List<DRecordList> list=dRecordListService.getDRListByNameAndState(name,"待缴纳");
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据用户名 书名 罚款原因模糊查找查找对应的罚款记录
    @RequestMapping("/public/getDRListByKey")
    public Res getDRListByKey(@RequestParam("key") String key){
        List<DRecordList> list=dRecordListService.getDRListByKey(key);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名 罚款原因模糊查找对应用户的未缴纳罚单
    @RequestMapping("/public/searchUserNowDRListByKey")
    public Res searchUserNowDRListByKey(@RequestParam("user") String user,@RequestParam("key") String key){
        List<DRecordList> list=dRecordListService.searchUserNowDRListByKey(user, key);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名 罚款原因 状态模糊查找对应用户的罚单记录
    @RequestMapping("/public/searchUserDRListByKey")
    public Res searchUserDRListByKey(@RequestParam("user") String user,@RequestParam("key") String key){
        List<DRecordList> list=dRecordListService.searchUserDRListByKey(user, key);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //添加罚单
    public Res addDR(String reason, BorrowLog borrowLog){
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(time);
        User user = userService.getUserById(borrowLog.getUser_id());
        user.setdRecord_num(user.getdRecord_num()+1);
        DefaultRecord defaultRecord =new DefaultRecord(0,borrowLog.getUser_id(),borrowLog.getBorrow_id(),reason,date,"待缴纳");
        if(defaultRecordService.addDefaultRecord(defaultRecord)){
            if(userService.upUser(user)){
                if(reason.equals("超时还书"))
                    return new Res(Res.SUCCESS,"超时还书成功，罚单已生成！",null);
                else
                    return new Res(Res.SUCCESS,"图书挂失成功，罚单已生成！",null);
            }
            else return new Res(Res.FAILURE,"错误！用户信息更新失败",null);
        }
        else return new Res(Res.FAILURE,"错误！罚单生成失败",null);

    }
    //缴纳罚单
    @RequestMapping("/public/delDR")
    public Res delDR(@RequestParam("id") int id){
        DefaultRecord defaultRecord =defaultRecordService.getDRecordById(id);
        defaultRecord.setState("已缴纳");
        User user =userService.getUserById(defaultRecord.getUser_id());
        user.setdRecord_num(user.getdRecord_num()-1);
        if(defaultRecordService.upDefaultRecord(defaultRecord)) {
            if(userService.upUser(user))
                return new Res(Res.SUCCESS,"罚单缴纳成功！",null);
            else
                return new Res(Res.FAILURE,"用户信息更新失败",null);
        }
        else
            return new Res(Res.FAILURE,"罚单信息更新失败",null);
    }
}
