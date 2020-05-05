package com.routon.plcloud.device.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleMapper {

    @Select("select role_name from user_role where username=#{username}")
    List<String> selectRolesByUsername(@Param("username") String username);

}
