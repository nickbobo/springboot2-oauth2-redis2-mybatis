package com.nick.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nick.bean.User;
import com.nick.mapper.UserMapper;
import com.nick.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by nick on 2018/11/7.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;


    @CachePut(value = "user", key = "#user.id")
    @Override
    public User insert(User user) {
        userMapper.insert(user);
        log.info("进入add方法");
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User find(int id) {
        log.info("进入find方法");
        return userMapper.find(id);

    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(int id){
        userMapper.delete(id);
        log.info("进入delete方法");
    }


    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.findByPage();
    }
}
