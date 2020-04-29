package com.routon.plcloud.device.api.controller;

import com.routon.plcloud.device.core.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FireWang
 * @date 2020/4/26 17:15
 */
@RestController
public class HelloWorldController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        String msg = "Hello, SpringBoot!";
        String msgfromcore = helloService.sayhello();
        if(msgfromcore != null){
            msg = msgfromcore;
        }
        return msg;
    }

    @GetMapping("/addhello")
    public String addhello(){
        String msg = "Hello, SpringBoot!";
        String msgfromcore = helloService.addhello();
        if(msgfromcore != null){
            msg = msgfromcore;
        }
        return msg;
    }

    @GetMapping("/deletehello")
    public String deletehello(){
        String msg = "Hello, SpringBoot!";
        String msgfromcore = helloService.deletehello();
        if(msgfromcore != null){
            msg = msgfromcore;
        }
        return msg;
    }
}
