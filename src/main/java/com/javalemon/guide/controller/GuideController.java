package com.javalemon.guide.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lemon
 * @date 2019-07-13
 * @desc
 */

@Controller
@Configuration
@Data
public class GuideController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userInfo", "lemon");
        return "guide";
    }

    @GetMapping("/guide")
    public String guide(Model model) {
        model.addAttribute("userInfo", port);
        System.out.println("==============" + port);
        return "guide";
    }

}
