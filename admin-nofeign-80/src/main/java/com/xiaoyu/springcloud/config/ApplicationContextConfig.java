package com.xiaoyu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //    @LoadBalanced  //注解赋予RestTemplate负载均衡的能力
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
