package com.cyt.library.dao;
import com.cyt.library.bean.DefaultRecord;
public interface DefaultRecordDao {
    Boolean addDefaultRecord(DefaultRecord defaultRecord);
    Boolean upDefaultRecord(DefaultRecord defaultRecord);
    Boolean delDefaultRecord(int id);
    int getUserDRecordNum(int id);
    DefaultRecord getDRecordById(int id);
    int getUserDRecordHistroyNum(int id);
}
