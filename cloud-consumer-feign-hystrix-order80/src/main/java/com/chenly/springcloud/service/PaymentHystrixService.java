package com.chenly.springcloud.service;

import com.chenly.springcloud.service.impl.PaymentHystrixFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: chenly
 * @date: 2021-03-24 15:55
 * @description:
 * @version: 1.0
 */

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-SERVICE" ,fallback = PaymentHystrixFallbackService.class)
public interface PaymentHystrixService {


    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);



}
