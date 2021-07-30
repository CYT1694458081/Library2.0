package com.cyt.library.dao;

import com.cyt.library.bean.LogNum;

import java.util.List;

public interface LogNumDao {
    List<LogNum> getAllUserLogNum();
    List<LogNum> searchUserLogNumByKey(String key);
}
