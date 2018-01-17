package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.serivce.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserService userService;

    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

    @RequestMapping("/hello/{myName}")
    String index(@PathVariable String myName) {
        return "Hello," + myName + "!";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Object getUserlist() {

        Page<User> users = userService.selectByPrimaryList(1, 5);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfobaseinfo = new PageInfo<>(users);

        return pageInfobaseinfo.getList().size() > 0 ? pageInfobaseinfo : null;
    }
}
