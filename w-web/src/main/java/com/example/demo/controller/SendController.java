package com.example.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.api.service.RabbitMQService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by Raytine on 2017/12/4.
 */


/**
 * 测试RabbitMQ发送消息的Controller
 * @author Raye
 *
 */
@RestController
public class SendController {

    @Reference(version = "1.0.0")
    private RabbitMQService rabbitMQService;
    /**
     * 向消息队列1中发送消息
     * @param msg
     * @return
     */
    @RequestMapping("send1")
    public void send1(String msg){
        rabbitMQService.send(msg);
    }

    /**
     * 消息的回调，主要是实现RabbitTemplate.ConfirmCallback接口
     * 注意，消息回调只能代表成功消息发送到RabbitMQ服务器，不能代表消息被成功处理和接受
     */
 /*   public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause+"\n重新发送");

        }
    }*/
    @RabbitListener(queues = "queue_one")
    public void process(String hello) {
        System.out.println("queue_one接受的消息为 : " + hello);
    }


}