package com.routon.plcloud.device.api;


import com.routon.plcloud.device.core.CoreConfiguration;
import com.routon.plcloud.device.data.DataConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author FireWang
 * @date 2020/4/26 17:00
 */
@SpringBootApplication
@Import({CoreConfiguration.class, DataConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}