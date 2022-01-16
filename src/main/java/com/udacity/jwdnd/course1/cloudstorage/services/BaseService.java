package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class BaseService {
    @Autowired
    private UserMapper userMapper;
//    public BaseService(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
    public BaseService(){}

    public User getUser(String username) {
        return userMapper.getUser(username);
    }
}
