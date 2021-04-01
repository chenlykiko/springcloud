package com.chenly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: chenly
 * @date: 2021-03-31 16:30
 * @description:
 * @version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class MainConfigClient3366 {


    public static void main(String[] args) {
        SpringApplication.run(MainConfigClient3366.class,args);
    }

}
