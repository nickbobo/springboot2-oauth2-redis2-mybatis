package com.nick.service;

import com.github.pagehelper.Page;
import com.nick.bean.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * Created by nick on 2018/11/7.
 */
@ComponentScan({"com.nick.mapper"})
public interface UserService {
    public User insert(User user);
    public void update(User user);
    public User find(int id);
    public void delete(int id);

    Page<User> findByPage(int pageNo, int pageSize);
}
