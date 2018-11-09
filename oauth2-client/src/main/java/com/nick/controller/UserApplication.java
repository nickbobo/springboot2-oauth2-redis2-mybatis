package com.nick.controller;

import com.github.pagehelper.Page;
import com.nick.bean.User;
import com.nick.page.PageInfo;
import com.nick.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by nick on 2018/11/7.
 */
@RestController
public class UserApplication {

    private static final Logger log = LoggerFactory.getLogger(UserApplication.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/say")
    public String say(){
        return "springboot-a"+userService;
    }

    @RequestMapping("/find")
    public String find(){
        User user =  userService.find(1);
        ModelAndView mav = new ModelAndView();
        mav.addObject("user","sadf");
        return "HelloWord"+"fasdf--"+user.getUsername()+"--"+user.getPassword();
    }
    @ResponseBody
    @GetMapping("/sort")
    public PageInfo<User> tkBase() {

        Page<User> user = userService.findByPage(1, 2);

        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> userPageinfo = new PageInfo<>(user);

//        com.github.pagehelper.PageInfo<User> userPageinfo1 = new com.github.pagehelper.PageInfo<>(user);


        log.info("111 -- [{}]",userPageinfo);
        return userPageinfo;//.toString()+"---------"+userPageinfo1.toString();//userPageInfo.toString();
    }
}
