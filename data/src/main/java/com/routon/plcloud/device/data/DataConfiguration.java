package com.routon.plcloud.device.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author FireWang
 * @date 2020/4/26 19:59
 */
@ComponentScan
@Configuration
@MapperScan("com.routon.plcloud.device.data.mapper")
public class DataConfiguration {

}
