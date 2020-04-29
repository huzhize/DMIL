package com.routon.plcloud.device.data.mapper;

import com.routon.plcloud.device.data.entity.Helloworld;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HelloworldMapper {
    @Select("${sql}")
    List<Map> selectBySql(@Param("sql") String sql);

    @Insert("insert into helloworld(api, core, data) " +
            "values(#{api}, #{core}, #{data})")
    int insertNew(Helloworld helloworld);

    @Update("{sql}")
    int uopdateBySql(Helloworld helloworld);

    @Delete("delete from helloworld where id = #{id}")
    int deleteById(@Param("id") int id);

    @Delete("delete from helloworld")
    int deleteall();
}