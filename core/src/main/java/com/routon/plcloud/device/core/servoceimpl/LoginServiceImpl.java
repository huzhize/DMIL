package com.routon.plcloud.device.core.servoceimpl;

import com.routon.plcloud.device.core.service.LoginService;
import com.routon.plcloud.device.data.mapper.UserMapper;
import com.routon.plcloud.device.data.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public String queryUser(String username) {
        return userMapper.selectPasswordByUsername(username);
    }

    @Override
    public List<String> queryRoles(String username) {
        return userRoleMapper.selectRolesByUsername(username);
    }
}
