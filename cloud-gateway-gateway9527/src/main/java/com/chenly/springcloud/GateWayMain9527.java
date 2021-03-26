package com.chenly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: chenly
 * @date: 2021-03-26 09:46
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {


    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
    }


}
