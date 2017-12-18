package com.example.demo.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {
    @Value("${spring.dubbo.consumer.timeout}")
    private int timeout;

    @Bean
    public ConsumerConfig getDubboConsumerTimeout(){
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(timeout);
        return consumerConfig;
    }
}
