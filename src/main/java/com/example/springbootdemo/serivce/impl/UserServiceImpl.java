package com.example.springbootdemo.serivce.impl;

import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.serivce.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author asus
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    /*
  * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
  * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
  * number 开始页数
  * Size 每页显示的数据条数
  * */
    @Override
    public Page<User> selectByPrimaryList(int number, int size) {
        PageHelper.startPage(number, size);
        return userMapper.selectByPrimaryList();
    }
}
