package com.chenly.springcloud.service;

import com.chenly.springcloud.domain.Order;

/**
 * @author: chenly
 * @date: 2021-04-12 16:01
 * @description:
 * @version: 1.0
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}


