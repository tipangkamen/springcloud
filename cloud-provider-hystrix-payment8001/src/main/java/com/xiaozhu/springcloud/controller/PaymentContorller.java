package com.xiaozhu.springcloud.controller;

import com.xiaozhu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sound.sampled.Line;

@RestController
@Slf4j
public class PaymentContorller {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentinfo_OK(id);
        log.info("....Result"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/Timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result = paymentService.paymentinfo_Timeout(id);
        log.info("....Result"+result);
        return result;
    }
}
