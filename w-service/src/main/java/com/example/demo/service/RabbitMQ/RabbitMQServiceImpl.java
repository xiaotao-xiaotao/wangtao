package com.example.demo.service.RabbitMQ;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.api.service.RabbitMQService;
import com.example.demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import java.util.UUID;

/**
 * Created by Raytine on 2017/12/5.
 */
@Service(version = "1.0.0")
//@RabbitListener(queues = "queue_one1")
public class RabbitMQServiceImpl implements RabbitMQService{

    private RabbitTemplate rabbitTemplate;
    /**
     * 配置发送消息的rabbitTemplate，因为是构造方法，所以不用注解Spring也会自动注入（应该是新版本的特性）
     * @param rabbitTemplate
     */
    public RabbitMQServiceImpl(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

   // @RabbitHandler
   // public void process(String hello) {
       // System.out.println("queue_one接受的消息为 : " + hello);
    //}

    @Override
    public void send(String msg) {
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTINGKEY1, msg, correlationId);
    }
}
