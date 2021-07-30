package com.cyt.library.controller;

import com.cyt.library.bean.User;
import com.cyt.library.domain.Res;
import com.cyt.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//用户信息操作
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //获取当前所有用户
    @RequestMapping("/public/getAllUser")
    public Res show(){
        List<User> list=userService.getAllUser();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //删除用户
    @RequestMapping("/public/delUser")
    public Res del(@RequestParam("del") int id){
        User user=userService.getUserById(id);
        System.out.println(user.getdRecord_num()+"/"+user.getBorrow_num());
        if(user.getBorrow_num()>0 || user.getdRecord_num()>0)
            return new Res(Res.ERROR,"该用户有在借书籍！无法删除",null);
        else{
            if(userService.delUser(id)){
                return new Res(Res.SUCCESS,"删除成功！",null);
            }else {
                return new Res(Res.ERROR,"删除失败！",null);
            }
        }

    }
    //添加用户
    public Res adduser(User user){
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(time);
        user.setRegtime(date);
        if(userService.getUserByName(user.getName())!=null){
            return new Res(Res.FAILURE,"用户名已经存在！",null);
        }
        if(userService.addUser(user)){
            return new Res(Res.SUCCESS,"添加成功！",null);
        }else {
            return new Res(Res.ERROR,"添加失败！",null);
        }
    }

    //管理员添加用户
    @RequestMapping("/public/addUser")
    public Res GMadd(User user){
        Res res=adduser(user);
        return res;

    }
    //用户注册
    @RequestMapping("/public/regist")
    public Res regist(User user){
        System.out.println(user);
        user.setRole("普通用户");
        user.setBorrow_num(0);
        Res res=adduser(user);
        return res;

    }
    //更新用户信息
    @RequestMapping("/public/upUser/")
    public Res up(User user){
        User user1 = userService.getUserByName(user.getName());
        if(user1.getUser_id()==user.getUser_id()){
            if(userService.upUser(user)){
                return new Res(Res.SUCCESS,"修改成功！",null);
            }
            else {
                return new Res(Res.ERROR,"修改失败！",null);
            }
        }
        else return new Res(Res.ERROR,"存在重复用户名！",null);



    }

    //模糊查找用户
    @RequestMapping("/public/searchUser")
    public Res select(@RequestParam("searchParam") String keyword){
        List<User> list=userService.searchUser(keyword);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据id获取对应用户信息
    @RequestMapping("/public/getUserById")
    public Res getById(@RequestParam("id") int id){
        User user =userService.getUserById(id);
        return new Res(Res.SUCCESS,"查找成功",user);
    }

}
