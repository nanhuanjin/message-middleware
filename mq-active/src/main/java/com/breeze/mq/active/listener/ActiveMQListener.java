package com.breeze.mq.active.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author breeze
 * @date 2020/6/3
 */
@Component
@Slf4j
public class ActiveMQListener {

    @JmsListener(destination="active.queue", containerFactory = "queueListener")
    public void activemqQueueListener(String message) {
        log.info("active-queue：" + message);
    }

    @JmsListener(destination="active.topic", containerFactory = "topicListener")
    public void activemqTopicListener1(String message) {
        log.info("active-topic1：" + message);
    }

    @JmsListener(destination="active.topic", containerFactory = "topicListener")
    public void activemqTopicListener2(String message) {
        log.info("active-topic2：" + message);
    }
}
