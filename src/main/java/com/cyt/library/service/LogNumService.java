package com.cyt.library.service;

import com.cyt.library.bean.LogNum;
import com.cyt.library.dao.LogNumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogNumService {
    @Autowired
    private LogNumDao logNumDao;
    public List<LogNum> getAllUserLogNum(){return logNumDao.getAllUserLogNum();}
    public List<LogNum> searchUserLogNumByKey(String key){return logNumDao.searchUserLogNumByKey("%"+key+"%");}

}
