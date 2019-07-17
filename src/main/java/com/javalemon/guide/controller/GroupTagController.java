package com.javalemon.guide.controller;

import com.javalemon.guide.common.Result;
import com.javalemon.guide.model.dto.MessageDTO;
import com.javalemon.guide.service.GroupTagService;
import com.javalemon.guide.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author lemon
 * @date 2019-07-14
 * @desc
 */

@Controller
@RequestMapping("tag")
public class GroupTagController {

    @Resource
    private GroupTagService groupTagService;

    @GetMapping("showTag")
    public String showTag(HttpServletRequest request, Model model) {
        return "tag";
    }

    @PostMapping("addTag")
    @ResponseBody
    public Result addTag(@RequestParam String content) {

        return Result.success();
    }
}
