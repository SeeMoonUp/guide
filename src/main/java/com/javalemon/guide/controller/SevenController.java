package com.javalemon.guide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lemon
 * @date 2019-07-14
 * @desc
 */

@Controller
@RequestMapping("seven")
public class SevenController extends BaseController{


    @GetMapping("love")
    public String showMessage(HttpServletRequest request, Model model) {
        return "seven";
    }
}
