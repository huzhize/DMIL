package com.routon.plcloud.device.core.service;

import java.util.List;

public interface LoginService {
    public String queryUser(String username);
    public List<String> queryRoles(String username);
}
