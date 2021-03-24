package com.chenly.rules;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenlinyan
 * @version : 1.0
 * @date : 2021/3/22 15:30
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        //定义为随机
        return new RandomRule(); //随机

//        return new RetryRule(); //
//        return new WeightedResponseTimeRule();
//        return new BestAvailableRule();
//        return new AvailabilityFilteringRule();
//        return new ZoneAvoidanceRule();
//        return new RoundRobinRule();
    }


}
