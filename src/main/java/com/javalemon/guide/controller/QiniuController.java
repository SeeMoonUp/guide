package com.javalemon.guide.controller;

import com.qiniu.util.Auth;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lemon
 * @date 2019-09-14
 * @desc
 */

@Controller
@Configuration
@RequestMapping("qiniu")
public class QiniuController {

    @PostMapping("getToken")
    @ResponseBody
    public String home(HttpServletRequest request) {
        String accessKey = "CM1Xk5INASWuZfY8AX6f5xOVXx4_MlMo7ETRej-J";
        String secretKey = "1KuZD2XPAHmQRB9072ZsdwmjF1_uHKtdhuTy60wW";
        String bucket = "bit-video";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
}
