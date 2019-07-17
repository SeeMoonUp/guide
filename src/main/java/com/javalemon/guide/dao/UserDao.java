package com.javalemon.guide.dao;

import com.javalemon.guide.dao.mapper.MessageMapper;
import com.javalemon.guide.dao.mapper.UserMapper;
import com.javalemon.guide.model.dto.MessageDTO;
import com.javalemon.guide.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息
 */
@Repository
public class UserDao {
    @Resource
    private UserMapper userMapper;

    public int addUser(UserDTO userDTO) {
        return userMapper.addUser(userDTO);
    }

    public UserDTO getUser(int userId) {
        return userMapper.getUser(userId);
    }
}
