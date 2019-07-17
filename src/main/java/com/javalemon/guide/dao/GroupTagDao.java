package com.javalemon.guide.dao;

import com.javalemon.guide.dao.mapper.GroupMapper;
import com.javalemon.guide.dao.mapper.GroupTagMapper;
import com.javalemon.guide.model.dto.GroupDTO;
import com.javalemon.guide.model.dto.GroupTagDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息
 */
@Repository
public class GroupTagDao {
    @Resource
    private GroupTagMapper groupTagMapper;

    public int addGroupTag(GroupTagDTO groupTagDTO) {
        return groupTagMapper.addGroupTag(groupTagDTO);
    }

    public List<GroupTagDTO> listGroupTag(int userId, int groupId) {
        return groupTagMapper.listGroupTag(userId, groupId);
    }

    public int deleteGroupTag(int groupTagId) {
        return groupTagMapper.deleteGroupTag(groupTagId);
    }
}
