package com.javalemon.guide.dao.mapper;

import com.javalemon.guide.model.dto.GroupDTO;
import com.javalemon.guide.model.dto.UserDTO;

import java.util.List;

/**
 *
 */
public interface GroupMapper {

    int addGroup(GroupDTO groupDTO);

    List<GroupDTO> listGroup(int userId);

    int deleteGroup(int groupId);
}
