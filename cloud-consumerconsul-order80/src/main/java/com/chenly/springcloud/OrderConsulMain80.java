package com.chenly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : chenlinyan
 * @version : 1.0
 * @date : 2021/3/22 14:11
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class OrderConsulMain80 {


    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }


}
