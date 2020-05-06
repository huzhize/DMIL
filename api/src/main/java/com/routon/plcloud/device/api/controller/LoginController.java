package com.routon.plcloud.device.api.controller;

import com.routon.plcloud.device.core.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FireWang
 * @date 2020/4/27 16:09
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("index")
    public String index(){
        return "/login";
    }

    @RequestMapping("/developinfo")
    public String toinfo(){
        //这里返回页面路径
        return "/info";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e){
            return "用户名不存在";
        } catch (IncorrectCredentialsException e){
            return "密码错误";
        }
        return "/authc/index";
    }


    @RequestMapping("unauthc")
    @ResponseBody
    public String unauthc(){
        return "unauthc!MF!无访问权限";
    }


}
