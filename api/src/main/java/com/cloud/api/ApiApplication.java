package com.cloud.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : lingjun.jlj
 * @description : 服务提供
 */

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.cloud.api.persist")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
