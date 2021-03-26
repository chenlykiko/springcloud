package com.chenly.springcloud.service.impl;

import com.chenly.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author: chenly
 * @date: 2021-03-25 14:10
 * @description:
 * @version: 1.0
 */
@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService {


    @Override
    public String paymentInfo_ok(Integer id) {
        return "paymentInfo_ok , fallback";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "paymentInfo_Timeout , fallback";
    }
}
