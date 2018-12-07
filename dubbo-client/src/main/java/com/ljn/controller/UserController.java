package com.ljn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljn.entity.User;
import com.ljn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password,
                              HttpSession session) {
        // 判断用户名是否为空
        boolean checkName = (null == username || "".equals(username));
        // 判断密码是否为空
        boolean checkPassord = (null == password || "".equals(password));
        ModelAndView mv = new ModelAndView();
        if (checkName || checkPassord) {
            session.setAttribute("msg", "用户名和密码不能为空!");
            mv.setViewName("index");
            return mv;
        }
        // 在数据库中查找
        User user = userService.checkLogin(username, password);
        if (null == user) {
            session.setAttribute("msg", "用户名或者密码错误!");
            mv.setViewName("index");
            return mv;
        } else {
            session.setAttribute("user", user);
            System.out.println("用户: " + user + " 登录成功!");
            mv.setViewName("success");
            return mv;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(User user, HttpSession session) {
        String username = user.getUsername();
        //在数据库中查找该用户名 如果为空则可以添加
       if(userService.findByUsername(username)==null){
           userService.save(user);
           return "index";
           /* Rocketmq 发送注册成功消息*/

       }else{
           session.setAttribute("msg","用户名已存在！");
           return "redirect:/register";//失败
       }
    }

    @RequestMapping("/getAllUser")
    public String getAllUser(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("userList",user);
        return "allUser";
    }















}



