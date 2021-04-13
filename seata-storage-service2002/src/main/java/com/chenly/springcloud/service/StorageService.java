package com.chenly.springcloud.service;

/**
 * @author: chenly
 * @date: 2021-04-12 16:16
 * @description:
 * @version: 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);


}
