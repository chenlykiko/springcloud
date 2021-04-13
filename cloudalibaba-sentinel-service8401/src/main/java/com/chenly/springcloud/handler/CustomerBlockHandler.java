package com.chenly.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chenly.springcloud.entities.CommonResult;

/**
 * @author: chenly
 * @date: 2021-04-12 10:38
 * @description:
 * @version: 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handleException1(BlockException exception){
        return new CommonResult(2021,"自定义的限流处理信息......CustomerBlockHandler---1");
    }


    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2021,"自定义的限流处理信息......CustomerBlockHandler---2");
    }
}
