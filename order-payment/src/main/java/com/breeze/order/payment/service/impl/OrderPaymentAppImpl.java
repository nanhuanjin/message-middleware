package com.breeze.order.payment.service.impl;

import com.breeze.mq.common.vo.PayVO;
import com.breeze.order.payment.service.OrderPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.text.DecimalFormat;

/**
 * @author breeze
 * @date 2020/6/1
 */
@Service
@Slf4j
public class OrderPaymentAppImpl implements OrderPaymentService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public int submitOrder(String orderNumber) throws JMSException {
        //组装支付数据
        PayVO payVO = new PayVO();
        payVO.setOrderName("调起沙箱支付");
        payVO.setOrderNumber(orderNumber);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        payVO.setMoney(decimalFormat.format(21500));
        payVO.setContent("测试测试");

        //TODO：调起沙箱支付

        //模拟支付宝异步回调
        this.payOrderWithActiveMQ(payVO.getOrderNumber());
        this.payOrderWithRabbitMQ(payVO.getOrderNumber());
        this.payOrderWithRocketMQ(payVO.getOrderNumber());
        this.payOrderWithKafkaMQ(payVO.getOrderNumber());

        return 1;
    }

    @Override
    public int payOrderWithActiveMQ(String orderNumber) throws JMSException {
        log.info("activemq发送消息成功：{}", "Queue");
        //队列消息：一个消息只能被一个消费者使用。
        this.jmsMessagingTemplate.convertAndSend(this.queue, "queue：" + orderNumber);

        log.info("activemq发送消息成功：{}", "Topic");
        this.jmsMessagingTemplate.convertAndSend(this.topic, "topic：" + orderNumber);

        return 1;
    }

    @Override
    public int payOrderWithRabbitMQ(String orderNumber) {
        log.info("RabbitMq发送消息成功：{}", orderNumber);
        this.amqpTemplate.convertAndSend("ORDER-EXCHANGE", "order.pay", "RabbitMq：" + orderNumber);
        return 1;
    }

    @Override
    public int payOrderWithRocketMQ(String orderNumber) {
        log.info("RocketMq发送消息成功：{}", orderNumber);
        this.rocketMQTemplate.syncSend("rocketTopic", "RocketMq：" + orderNumber);
        return 1;
    }

    @Override
    public int payOrderWithKafkaMQ(String orderNumber) {
        return 1;
    }
}
