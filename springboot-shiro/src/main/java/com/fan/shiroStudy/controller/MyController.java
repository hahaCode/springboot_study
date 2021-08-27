package com.fan.shiroStudy.controller;

import com.fan.shiroStudy.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping({"/", "/index"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "Hello,Shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String addUser() {
        return "user/addUser";
    }

    @RequestMapping("/user/update")
    public String updateUser() {
        return "user/updateUser";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //执行登录
        try {
            subject.login(token);
            return "index";
        } catch (AuthenticationException e) {
            model.addAttribute("msg", e.getMessage());
            return "/login";
        }
    }

    @RequestMapping("/unauthorized")
    @ResponseBody
    public String unauthorized() {
        return "没有权限!";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/toLogin";
    }
}
