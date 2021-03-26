package com.chenly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: chenly
 * @date: 2021-03-24 15:51
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
//@EnableCircuitBreaker
@EnableHystrix
public class OrderHystrixMain80 {


    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class ,args);
    }


}
