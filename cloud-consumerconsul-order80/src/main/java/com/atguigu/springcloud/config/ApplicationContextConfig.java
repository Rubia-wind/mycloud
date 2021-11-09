package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 注：如果这里不加@LoadBalanced，会出现UnknownHostException异常！！！
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
