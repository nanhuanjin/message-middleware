package com.breeze.mq.rocket.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author breeze
 * @date 2020/6/3
 */
@Component
@Slf4j
@RocketMQMessageListener(topic = "rocket-topic", consumerGroup = "rocket-mq-service")
public class RocketMqListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("RocketMq消费方：{}", s);
    }
}
