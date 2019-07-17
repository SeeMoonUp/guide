package com.javalemon.guide.controller;

import com.javalemon.guide.common.Result;
import com.javalemon.guide.model.MessageVO;
import com.javalemon.guide.model.dto.MessageDTO;
import com.javalemon.guide.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author lemon
 * @date 2019-07-14
 * @desc
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private MessageService messageService;

    @GetMapping("showUser")
    public String showUser(HttpServletRequest request, Model model) {
        return "user";
    }

    @PostMapping("addUser")
    @ResponseBody
    public Result addUser(@RequestParam String content) {

        Result result = messageService.addMessage(MessageDTO.builder()
                .content(content)
                .sendUserId(1)
                .sendUserName("lemon")
                .receiveUserId(2)
                .createTime(new Date())
                .build());
        return result;
    }
}
