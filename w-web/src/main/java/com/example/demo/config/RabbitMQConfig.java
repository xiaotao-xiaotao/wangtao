package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq 的配置类
 *
 * @author Raye
 * @since 2016年10月12日10:57:44
 */
@Configuration
public class RabbitMQConfig {
    /** 消息交换机的名字*/
    public static final String EXCHANGE = "my-mq-exchange";
    /** 队列key1*/
    public static final String ROUTINGKEY1 = "queue_one_key1";
    /** 队列key2*/
    public static final String ROUTINGKEY2 = "queue_one_key2";

    @Bean
    public Queue queue() {
        return new Queue("queue_one", true); //队列持久
    }
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(RabbitMQConfig.ROUTINGKEY1);
    }
}