package com.fan.springbootWeb.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        //省去验证业务, 简化为不为空就可以登录

        if(StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            //其实应该存user对象, 这里没有连数据库, 先这样简化
            session.setAttribute("loginUser", username);
            return "redirect:/dashboard.html";
        } else {
            model.addAttribute("msg", "用户名及密码不能为空!");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }

}
