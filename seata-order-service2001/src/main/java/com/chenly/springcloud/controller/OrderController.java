package com.chenly.springcloud.controller;

import com.chenly.springcloud.domain.CommonResult;
import com.chenly.springcloud.domain.Order;
import com.chenly.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenly
 * @date: 2021-04-12 16:02
 * @description:
 * @version: 1.0
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }

}
