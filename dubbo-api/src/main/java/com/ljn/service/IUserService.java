package com.ljn.service;

import com.ljn.entity.User;

import java.util.List;

public interface IUserService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    void save(User user);

    /**
     * 查询所有用户
     * @param
     * @return
     */
    List<User> findAll();

    /**
     * 删除
     * @param id
     */
     boolean delete(Integer id);

    /**
     * 编辑
     * @param user
     */
     String update(User user);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
     User findByUsername(String username);


}
