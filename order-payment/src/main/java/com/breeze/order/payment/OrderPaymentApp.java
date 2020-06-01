package com.breeze.order.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author breeze
 * @date 2020/6/1
 */
@SpringBootApplication
@EnableJms
public class OrderPaymentApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderPaymentApp.class, args);
    }
}
