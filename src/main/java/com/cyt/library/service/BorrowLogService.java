package com.cyt.library.service;

import com.cyt.library.bean.BorrowLog;
import com.cyt.library.dao.BorrowLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowLogService {
    @Autowired
    private BorrowLogDao borrowLogDao;
    public Boolean addBorrowLog(BorrowLog object){return borrowLogDao.addBorrowLog(object);}
    public Boolean delBorrowLog(int id){return borrowLogDao.delBorrowLog(id);}
    public Boolean upBorrowLog(BorrowLog object){return borrowLogDao.upBorrowLog(object);}
}
