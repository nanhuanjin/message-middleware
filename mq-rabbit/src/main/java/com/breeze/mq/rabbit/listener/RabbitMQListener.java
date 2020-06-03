package com.breeze.mq.rabbit.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author breeze
 * @date 2020/6/3
 */
@Component
@Slf4j
public class RabbitMQListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "ORDER-SUCCESS-QUEUE"),
            exchange = @Exchange(value = "ORDER-EXCHANGE",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC),
            key = {"order.pay"}
    ))
    public void payOrderSuccess(String orderCode) {
        log.info("RabbitMQ：{} - 支付成功，删减库存", orderCode);
    }

}
