package com.cyt.library.service;

import com.cyt.library.bean.User;
import com.cyt.library.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User getUserById(int id){return userDao.getUserById(id);}
    public User getUserByName(String name){return userDao.getUserByName(name);}
    public List<User> getAllUser(){return userDao.getAllUser();}
    public List<User> searchUser(String keyword){return userDao.searchUser("%"+keyword+"%");}
    public Boolean addUser(User object){return userDao.addUser(object);}
    public Boolean delUser(int id){return userDao.delUser(id);}
    public Boolean upUser(User object){return userDao.upUser(object);}
}
