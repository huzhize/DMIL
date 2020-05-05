package com.routon.plcloud.device.api;

import com.routon.plcloud.device.core.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String)principals.getPrimaryPrincipal();
        List<String> roles = loginService.queryRoles(username);
        /*if(roles!=null&&roles.size()>0){

        }*/
        authorizationInfo.addRoles(roles);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        String _password = loginService.queryUser(username);
        if(_password==null) {
            //该用户名不存在
            throw new UnknownAccountException();
        } else if(!_password.equals(password)) {
            //密码错误
            throw new IncorrectCredentialsException();
        }
        SimpleAuthenticationInfo authenticationInfo= new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),getName());
        return authenticationInfo;
    }
}
