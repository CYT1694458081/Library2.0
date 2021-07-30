package com.cyt.library.controller;

import com.cyt.library.bean.LogNum;
import com.cyt.library.domain.Res;
import com.cyt.library.service.LogNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//按要求获取各个用户当前的借阅和罚单记录数量
@RestController
public class LogNumController {
    @Autowired
    private LogNumService logNumService;
    //获取所有用户对应的记录数量
    @RequestMapping("/public/getAllUserLogNum")
    public Res getAllUserLogNum(){
        List<LogNum> list=logNumService.getAllUserLogNum();
        return new  Res(Res.SUCCESS,"查询完成",list);
    }
    //模糊查找对应用户的记录数量
    @RequestMapping("/public/searchUserLogNumByKey")
    public Res searchUserLogNumByKey(@RequestParam("key") String key){
        List<LogNum> list=logNumService.searchUserLogNumByKey(key);
        return new  Res(Res.SUCCESS,"查询完成",list);
    }
}
