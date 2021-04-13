package com.chenly.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chenly
 * @date: 2021-04-12 16:32
 * @description:
 * @version: 1.0
 */
@Configuration
@MapperScan({"com.chenly.springcloud.dao"})
public class MyBatisConfig {
}

