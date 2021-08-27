package com.fan.shiroStudy.config;

import com.fan.shiroStudy.domain.User;
import com.fan.shiroStudy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("UserRealm ====> doGetAuthorizationInfo");;
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        //添加当前用户的权限
        authorizationInfo.addStringPermission(currentUser.getPerms());

        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("UserRealm ====> doGetAuthenticationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.findUserByName(userToken.getUsername());

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("loginUser", user);
        if(user == null) {
            return null;   //UnknownAccountException
        }
        //密码认证shiro帮我做
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
