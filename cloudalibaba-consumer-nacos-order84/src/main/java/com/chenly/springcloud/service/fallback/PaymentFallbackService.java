package com.chenly.springcloud.service.fallback;

import com.chenly.springcloud.entities.CommonResult;
import com.chenly.springcloud.entities.Payment;
import com.chenly.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author: chenly
 * @date: 2021-04-12 11:53
 * @description:
 * @version: 1.0
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }


}
