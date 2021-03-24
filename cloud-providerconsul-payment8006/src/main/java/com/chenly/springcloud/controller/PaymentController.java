package com.chenly.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : chenlinyan
 * @version : 1.0
 * @date : 2021/3/22 10:30
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentzk(){
        return "springCloud with consul "+serverPort +"\t"+ UUID.randomUUID().toString();
    }


}
