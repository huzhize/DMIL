package com.routon.plcloud.device.api;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainDefinitionMap = new HashMap<String,String>();
        shiroFilterFactoryBean.setLoginUrl("/login/index");//未登录时的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/login/unauthc");//访问未授权页面
        shiroFilterFactoryBean.setSuccessUrl("/authc/index.html");//登录成功后的页面
        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/**","authc");
        filterChainDefinitionMap.put("/login/**", "anon");
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/auth/index.html","authc");
        filterChainDefinitionMap.put("/admin/index.html","roles[admin]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm());
        return  defaultWebSecurityManager;
    }
}
