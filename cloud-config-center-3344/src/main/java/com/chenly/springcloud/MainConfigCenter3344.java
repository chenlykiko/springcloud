package com.chenly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: chenly
 * @date: 2021-03-29 14:34
 * @description:
 * @version: 1.0
 */

@SpringBootApplication
@EnableConfigServer
public class MainConfigCenter3344 {


    public static void main(String[] args) {
        SpringApplication.run(MainConfigCenter3344.class,args);
    }


}
