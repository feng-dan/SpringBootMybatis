package com.example.springbootdemo.serivce;

import com.example.springbootdemo.model.User;
import com.github.pagehelper.Page;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Page<User> selectByPrimaryList(int number, int size);
}
