package com.chenly.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chenly
 * @date: 2021-03-26 10:22
 * @description:
 * @version: 1.0
 */
@Configuration
public class GateWayConfig {


    /**
     *
     * @param routeLocatorBuilder
     * @return
     */

    @Bean
    public  RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //https://news.baidu.com/guonei
        routes.route("path_route_guonei",
                r->r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();

    }


    @Bean
    public  RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //https://news.baidu.com/guonei
        routes.route("path_route_guoji",
                r->r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
        return routes.build();

    }



}
