package com.ws.user.service;

import com.ws.user.mapper.UserMapper;
import com.ws.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper um;

    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     * @return 用户对象
     */
    public User queryById(Long id){
        return um.selectByPrimaryKey(id);
    }
}
