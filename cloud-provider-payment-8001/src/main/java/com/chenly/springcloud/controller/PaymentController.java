package com.chenly.springcloud.controller;

import com.chenly.springcloud.entities.CommonResult;
import com.chenly.springcloud.entities.Payment;
import com.chenly.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : chenlinyan
 * @version : 1.0
 * @date : 2021/3/18 14:11
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("内容："+payment);
        int result = paymentService.create(payment);
        log.info("插入结果:"+result);
        if(result >0 ){
            return new CommonResult(200,"插入数据库成功,端口为："+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        if(payment !=null ){
            return new CommonResult(200,"查询成功，serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询id为"+id+",serverPort:"+serverPort);
        }
    }



    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        //所有的服务名称
        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance instance :instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;

    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }




    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
            return serverPort;
    }


}
