package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    /**
     * http://localhost:7001/
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }

}
