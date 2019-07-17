package com.javalemon.guide.dao.mapper;

import com.javalemon.guide.model.dto.GroupDTO;
import com.javalemon.guide.model.dto.GroupTagDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface GroupTagMapper {

    int addGroupTag(GroupTagDTO groupTagDTO);

    List<GroupTagDTO> listGroupTag(
            @Param("userId") int userId,
            @Param("groupId") int groupId);

    int deleteGroupTag(int groupTagId);
}
