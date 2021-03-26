package com.chenly.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenly
 * @date: 2021-03-24 11:52
 * @description:
 * @version: 1.0
 */
@Service
public class PaymentService {


    /**
     *
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id){
       return "线程池"+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id+" √";

    }

    /**
     *
     * @param id
     * @return
     */
    //一旦调用服务方法失败并抛出了错误信息之后，会自动
    // 调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            //执行过程超过配置的时间，调用fallbackMethod
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        int time = 3000;
        try{
            TimeUnit.MILLISECONDS.sleep(time);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

//        int age = 10/0;
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Timeout,id:"+id+"";

    }


    public String paymentInfo_TimeoutHandler(Integer id)
    {

        return "id"+id+":系统繁忙 "+Thread.currentThread().getName();
    }



    //=======服务熔断

//    HystrixCommandProperties  属性默认值

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
        commandProperties ={
            //是否开启断路器
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value = "true"),
            //请求次数
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "10"),
            //时间窗口期
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "10000"),
            //失败率达到多少后跳闸
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "60")
        }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if(id < 0){
            throw new RuntimeException("***id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "调用成功，serialNumber:"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试"+id;
    }


}
