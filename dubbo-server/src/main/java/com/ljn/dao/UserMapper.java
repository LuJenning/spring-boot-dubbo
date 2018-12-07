package com.ljn.dao;

import com.ljn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface UserMapper {
    User checkLogin(@Param(value = "username") String username, @Param(value = "password") String password);

    void save(User user);

    List<User> findAll();

    boolean deleteById(Integer id);

    String updateById(User user);

    User findByUsername(String username);
}
