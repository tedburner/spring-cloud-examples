package com.cloud.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : lingjun.jlj
 * @description: 普通服务提供
 */

@EnableDiscoveryClient
@SpringBootApplication
public class CommonApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApiApplication.class, args);
    }
}
