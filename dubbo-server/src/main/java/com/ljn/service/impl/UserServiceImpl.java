package com.ljn.service.impl;

import com.github.pagehelper.PageHelper;
import com.ljn.dao.UserMapper;
import com.ljn.entity.User;
import com.ljn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkLogin(String username, String password) {

        return userMapper.checkLogin(username,password);
    }

    @Override
    public void save(User user) {
         userMapper.save(user);
    }


    @Override
    public List<User> findAll() {
        List<User> allUser = userMapper.findAll();
        return allUser;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public String update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
