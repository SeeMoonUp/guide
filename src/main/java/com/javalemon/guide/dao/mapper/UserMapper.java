package com.javalemon.guide.dao.mapper;

import com.javalemon.guide.model.dto.UserDTO;

/**
 *
 */
public interface UserMapper {

    int addUser(UserDTO userDTO);

    UserDTO getUser(int userId);

    UserDTO getUserByEmail(String email);
}
