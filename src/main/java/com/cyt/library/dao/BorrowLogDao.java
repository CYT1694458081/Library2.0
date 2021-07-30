package com.cyt.library.dao;

import com.cyt.library.bean.BorrowLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BorrowLogDao {
    Boolean addBorrowLog(BorrowLog object);
    Boolean delBorrowLog(int id);
    Boolean upBorrowLog(BorrowLog object);
}
