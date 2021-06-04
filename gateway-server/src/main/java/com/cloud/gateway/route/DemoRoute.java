package com.cloud.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lingjun.jlj
 * @date: 2020/6/2 14:13
 * @description: 路由规则
 */
@Configuration
public class DemoRoute {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r->r.path("get")
                .uri("http://httpbin.org"))
                .build();
    }
}
