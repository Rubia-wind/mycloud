package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){

        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"😊";

    }

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){

//        int age = 10 / 0;

        int timeNumber = 5;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_Timeout,id:"+id+"\t"+"😊"+"耗时"+timeNumber+"秒钟";

    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeoutHandler,id:"+id+"\t"+"😢";
    }

}
