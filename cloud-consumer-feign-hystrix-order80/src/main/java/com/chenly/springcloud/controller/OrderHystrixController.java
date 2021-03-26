package com.chenly.springcloud.controller;

import com.chenly.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: chenly
 * @date: 2021-03-24 15:58
 * @description:
 * @version: 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_ok(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
//            commandProperties =
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "1500")
//    )
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        /*请求超时*/
//        String result = paymentHystrixService.paymentInfo_Timeout(id);

        /*运行异常*/
        int age = 10/0;
        String result = ""+age;
        return result;
    }


    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id){
        return "我是消费者，对方支付系统繁忙,请稍后";
    }


    /**
     * 全局fallback方法
     * @return
     */
    public String payment_Global_FallbackMethod(){

        return "Global异常处理信息，请稍后再试(T＿T)";
    }


}
