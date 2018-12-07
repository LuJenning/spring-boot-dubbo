package com.ljn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String loginIndex() {
        return "index";
    }

    @RequestMapping("registerPage.action")
    public String registerIndex(){

        return "register";
    }
    @RequestMapping("userManage.action")
    public String userManageIndex(){
        return "admin/userManage";
    }
}
