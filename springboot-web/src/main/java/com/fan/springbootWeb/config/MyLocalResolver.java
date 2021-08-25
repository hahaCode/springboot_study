package com.fan.springbootWeb.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("l");  //获取请求中的语言参数

        Locale locale = null;

        //请求连接携带了国际化的参数就用带过来的
        if(StringUtils.hasLength(lang)) {
            String[] s = lang.split("_");
            //获取国家和地区
            locale = new Locale(s[0], s[1]);
        } else {
            //请求没有携带国际化参数就用默认的
            locale = Locale.getDefault();
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
