package com.chenly.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author : chenlinyan
 * @version : 1.0
 * @date : 2021/3/22 16:03
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);




}
