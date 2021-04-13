package com.chenly.springcloud.service.impl;

import com.chenly.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author: chenly
 * @date: 2021-04-01 13:41
 * @description:
 * @version: 1.0
 */

@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**消息发送通道*/
    @Resource
    private MessageChannel output;


    @Override
    public String send(){

        String serial = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*********serial:"+serial);
        return null;
    }

}
