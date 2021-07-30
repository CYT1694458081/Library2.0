package com.cyt.library.service;

import com.cyt.library.bean.LogList;
import com.cyt.library.dao.LogListDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogListService {
    @Autowired
    private LogListDao logListDao;
    public List<LogList> getAllBorrowList(){return logListDao.getAllBorrowList();}
    public List<LogList> getBorrowListByNameAndState(@Param("user") String user,@Param("state") String state){return logListDao.getBorrowListByNameAndState(user,state);}
    public List<LogList> getBorrowListByName(String name){return logListDao.getBorrowListByName(name);}
    public List<LogList> searchBorrowListByName(String name){return logListDao.searchBorrowListByName(name);}
    public List<LogList> searchUserBorrowListByKey(@Param("user") String user,@Param("key") String key){return logListDao.searchUserBorrowListByKey(user,"%"+key+"%");}
    public List<LogList> getBorrowListByKey(String key){return logListDao.getBorrowListByKey("%"+key+"%");}
    public List<LogList> searchNowUserBorrowListByBook(@Param("user") String user,@Param("book") String book){return logListDao.searchNowUserBorrowListByBook(user,"%"+book+"%");}
    public List<LogList> searchUserBackListByBook(@Param("user") String user,@Param("book") String book){return logListDao.searchUserBackListByBook(user,"%"+book+"%");}
}
