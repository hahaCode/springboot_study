package com.fan.shiroStudy.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("webSecurityManager") DefaultWebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(webSecurityManager);

        //添加shiro的内置过滤器
        Map<String, String> filterMap = new LinkedHashMap<>();
        //filterMap.put("/user/add","anon");  // anon 无需认证就可以访问
        //filterMap.put("/user/update", "authc"); // authc 认证才可以访问  user 记住我之后才能访问  perms 拥有对某个资源的权限才能访问  role 拥有某个角色才能访问

        //设置页面的不同权限
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");

        //登录才能访问页面
        filterMap.put("/user/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        //设置登录页
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权的跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        return shiroFilterFactoryBean;
    }

    @Bean("webSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联realm
        securityManager.setRealm(userRealm);

        return securityManager;
    }


    @Bean("userRealm")
    public UserRealm getUserRealm() {
        return new UserRealm();
    }

    //整个ShiroDialect, 用于thymeleaf和shiro, 前端页面就可以用对应的标签了
    @Bean("shiroDialect")
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
