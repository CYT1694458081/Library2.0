package com.cyt.library.service;

import com.cyt.library.bean.DRecordList;
import com.cyt.library.dao.DRecordListDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DRecordListService {
    @Autowired
    private DRecordListDao dRecordListDao;
    public List<DRecordList> getAllDRList(){return dRecordListDao.getAllDRList();}
    public List<DRecordList> getDRListByName(String name){return dRecordListDao.getDRListByName(name);}
    public List<DRecordList> getDRListByKey(String key){return dRecordListDao.getDRListByKey("%"+key+"%");}
    public List<DRecordList> searchUserDRListByKey(@Param("user") String user, @Param("key") String key){return dRecordListDao.searchUserDRListByKey(user,"%"+key+"%");}
    public List<DRecordList> searchUserNowDRListByKey(@Param("user") String user, @Param("key") String key){return dRecordListDao.searchUserNowDRListByKey(user,"%"+key+"%");}
    public List<DRecordList> getDRListByNameAndState(@Param("user") String user, @Param("state") String state){return  dRecordListDao.getDRListByNameAndState(user,state);}
}
