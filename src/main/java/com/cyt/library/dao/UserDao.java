package com.cyt.library.dao;

import org.apache.ibatis.annotations.Mapper;
import com.cyt.library.bean.User;
import java.util.List;

public interface UserDao {
    User getUserById(int id);
    User getUserByName(String name);
    List<User> getAllUser();
    List<User> searchUser(String keyword);
    Boolean addUser(User object);
    Boolean delUser(int id);
    Boolean upUser(User object);
}
