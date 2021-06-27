package com.xiaozhu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    //正常访问
    public String paymentinfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_OK,id"+id+"\t"+"....";
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    //超时访问
    public String paymentinfo_Timeout(Integer id){
        int timeNumber=1;
        int age=10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_OK,id"+id+"\t"+"耗时"+timeNumber+"秒钟....";
    }

    public String paymentinfo_TimeoutHandler(Integer id){

        return "线程池："+Thread.currentThread().getName()+"  paymentinfo_TimeoutHandler,id"+id+"\t"+"出错了";
    }
}
