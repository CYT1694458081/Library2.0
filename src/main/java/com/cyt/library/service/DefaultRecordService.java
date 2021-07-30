package com.cyt.library.service;
import com.cyt.library.bean.DefaultRecord;
import com.cyt.library.dao.DefaultRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRecordService {
    @Autowired
    private DefaultRecordDao defaultRecordDao;
    public Boolean addDefaultRecord(DefaultRecord defaultRecord){return defaultRecordDao.addDefaultRecord(defaultRecord);}
    public Boolean delDefaultRecord(int id){return defaultRecordDao.delDefaultRecord(id);}
    public int getUserDRecordNum(int id){return  defaultRecordDao.getUserDRecordNum(id);}
    public Boolean upDefaultRecord(DefaultRecord defaultRecord){ return  defaultRecordDao.upDefaultRecord(defaultRecord);}
    public DefaultRecord getDRecordById(int id){return defaultRecordDao.getDRecordById(id);}
    public int getUserDRecordHistroyNum(int id){return  defaultRecordDao.getUserDRecordHistroyNum(id);}
}
