package com.chenly.springcloud.controller;

import com.chenly.springcloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: chenly
 * @date: 2021-04-01 13:43
 * @description:
 * @version: 1.0
 */
@RestController
public class SendMessageController {


    @Resource
    private MessageProviderImpl messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }


}
