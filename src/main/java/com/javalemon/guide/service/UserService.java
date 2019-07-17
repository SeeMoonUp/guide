package com.javalemon.guide.service;

import com.javalemon.guide.common.Result;
import com.javalemon.guide.dao.MessageDao;
import com.javalemon.guide.dao.UserDao;
import com.javalemon.guide.model.MessageVO;
import com.javalemon.guide.model.dto.MessageDTO;
import com.javalemon.guide.model.dto.UserDTO;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lemon
 * @date 2019-07-14
 * @desc
 */

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public Result addUser(UserDTO userDTO) {
        try {
            int res = userDao.addUser(userDTO);
            if (res >= 0) {
                return Result.success();
            } else {
                return Result.error(Result.CodeEnum.DAO_ERROR);
            }
        } catch (Exception e) {
            return Result.error(Result.CodeEnum.SERVICE_ERROR);
        }
    }

    public Result<UserDTO> getUser(int userId) {
        try {
            UserDTO userDTO = userDao.getUser(userId);
            return Result.success(userDTO);
        } catch (Exception e) {
            return Result.error(Result.CodeEnum.SERVICE_ERROR);
        }
    }
}
