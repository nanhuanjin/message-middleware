package com.breeze.order.payment.service.impl;

import com.breeze.mq.common.vo.PayVO;
import com.breeze.order.payment.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;
import java.text.DecimalFormat;

/**
 * @author breeze
 * @date 2020/6/1
 */
@Service
public class OrderPaymentAppImpl implements OrderPaymentService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @Override
    public int submitOrder(String orderNumber) {
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

        return 1;
    }

    @Override
    public int payOrderWithActiveMQ(String orderNumber) {
        return 1;
    }

    @Override
    public int payOrderWithRabbitMQ(String orderNumber) {
        return 1;
    }

    @Override
    public int payOrderWithRocketMQ(String orderNumber) {
        return 1;
    }

    @Override
    public int payOrderWithKafkaMQ(String orderNumber) {
        return 1;
    }
}
