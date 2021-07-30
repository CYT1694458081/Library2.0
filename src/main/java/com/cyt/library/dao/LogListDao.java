package com.cyt.library.dao;

import com.cyt.library.bean.LogList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogListDao {
    List<LogList> getAllBorrowList();
    List<LogList> getBorrowListByNameAndState(@Param("user") String user,@Param("state") String state);
    List<LogList> getBorrowListByName(String name);
    List<LogList> searchUserBorrowListByKey(@Param("user") String user,@Param("key") String key);
    List<LogList> getBorrowListByKey(String key);
    List<LogList> searchNowUserBorrowListByBook(@Param("user") String user,@Param("book") String book);
    List<LogList> searchUserBackListByBook(@Param("user") String user,@Param("book") String book);
    List<LogList> searchBorrowListByName(String name);
}
