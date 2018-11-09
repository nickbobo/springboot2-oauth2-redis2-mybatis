package com.nick.mapper;

import com.github.pagehelper.Page;
import com.nick.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * Created by nick on 2018/11/7.
 */
@Mapper
public interface UserMapper extends Serializable {
    public void insert(User user);

    public void update(User user);

    public void delete(int id);

    public User find(int id);

    Page<User> findByPage();
}
