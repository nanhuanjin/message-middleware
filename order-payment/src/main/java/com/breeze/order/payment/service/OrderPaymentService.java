package com.breeze.order.payment.service;

import javax.jms.JMSException;

/**
 * @author breeze
 * @date 2020/6/1
 */
public interface OrderPaymentService {

    /**
     * 提交订单 - 调起沙箱支付宝支付
     * @param orderNumber
     * @return
     */
    int submitOrder(String orderNumber) throws JMSException;

    /**
     * ActiveMQ版本 - 根据订单编号支付订单
     * @param orderNumber
     * @return
     */
    int payOrderWithActiveMQ(String orderNumber) throws JMSException;

    /**
     * RabbitMQ版本 - 根据订单编号支付订单
     * @param orderNumber
     * @return
     */
    int payOrderWithRabbitMQ(String orderNumber);

    /**
     * RocketMQ版本 - 根据订单编号支付订单
     * @param orderNumber
     * @return
     */
    int payOrderWithRocketMQ(String orderNumber);

    /**
     * KafkaMQ版本 - 根据订单编号支付订单
     * @param orderNumber
     * @return
     */
    int payOrderWithKafkaMQ(String orderNumber);


}
