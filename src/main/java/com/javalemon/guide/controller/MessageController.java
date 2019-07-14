package com.javalemon.guide.controller;

import com.javalemon.guide.common.Result;
import com.javalemon.guide.model.MessageVO;
import com.javalemon.guide.model.dto.MessageDTO;
import com.javalemon.guide.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lemon
 * @date 2019-07-14
 * @desc
 */

@Controller
@RequestMapping("message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("showMessage")
    public String showMessage(Model model) {
        Result<List<MessageVO>> listResult = messageService.listMessage(2);
        if (listResult.isSuccess()) {
            model.addAttribute("messageList", listResult.getData());
        }
        return "message";
    }

    @PostMapping("addMessage")
    @ResponseBody
    public Result addMessage(@RequestParam String content) {

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
