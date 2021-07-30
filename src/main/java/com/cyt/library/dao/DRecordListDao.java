package com.cyt.library.dao;


import com.cyt.library.bean.DRecordList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DRecordListDao {

    List<DRecordList> getAllDRList();
    List<DRecordList> getDRListByName(String name);
    List<DRecordList> getDRListByKey(String key);
    List<DRecordList> searchUserDRListByKey(@Param("user") String user, @Param("key") String key);
    List<DRecordList> searchUserNowDRListByKey(@Param("user") String user, @Param("key") String key);
    List<DRecordList> getDRListByNameAndState(@Param("user") String user, @Param("state") String state);
}
