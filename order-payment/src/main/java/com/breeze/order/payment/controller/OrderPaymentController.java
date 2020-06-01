package com.breeze.order.payment.controller;

import com.breeze.mq.common.consts.AppConsts;
import com.breeze.mq.common.exception.ApplicationException;
import com.breeze.mq.common.result.BaseResponse;
import com.breeze.mq.common.result.ResultCodeEnum;
import com.breeze.order.payment.service.OrderPaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author breeze
 * @date 2020/6/1
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "订单支付Controller")
public class OrderPaymentController {

    @Autowired
    private OrderPaymentService orderPaymentService;

    @ApiOperation("提交订单 - 调起沙箱支付宝支付")
    @GetMapping("/submit/order/{orderNumber}")
    public BaseResponse submitOrder(
            @ApiParam(name = "orderNumber", value = "订单编号", required = true)
            @PathVariable("orderNumber")String orderNumber) {

        int count = this.orderPaymentService.submitOrder(orderNumber);

        if (count == AppConsts.SUCCESS_COUNT) {
            return new BaseResponse().message("订单支付成功");
        } else {
            throw new ApplicationException(ResultCodeEnum.ORDER_PAY_ERROR);
        }
    }

    @ApiOperation("ActiveMQ版本 - 根据订单编号支付订单")
    @GetMapping("/success/active/{orderNumber}")
    public BaseResponse payOrderWithActiveMQ(
            @ApiParam(name = "orderNumber", value = "订单编号", required = true)
            @PathVariable("orderNumber")String orderNumber) {

        int count = this.orderPaymentService.payOrderWithActiveMQ(orderNumber);

        if (count == AppConsts.SUCCESS_COUNT) {
            return new BaseResponse().message("订单支付成功");
        } else {
            throw new ApplicationException(ResultCodeEnum.ORDER_PAY_ERROR);
        }
    }

    @ApiOperation("RabbitMQ版本 - 根据订单编号支付订单")
    @GetMapping("/success/rabbit/{orderNumber}")
    public BaseResponse payOrderWithRabbitMQ(
            @ApiParam(name = "orderNumber", value = "订单编号", required = true)
            @PathVariable("orderNumber")String orderNumber) {

        int count = this.orderPaymentService.payOrderWithRabbitMQ(orderNumber);

        if (count == AppConsts.SUCCESS_COUNT) {
            return new BaseResponse().message("订单支付成功");
        } else {
            throw new ApplicationException(ResultCodeEnum.ORDER_PAY_ERROR);
        }
    }

    @ApiOperation("RocketMQ版本 - 根据订单编号支付订单")
    @GetMapping("/success/rocket/{orderNumber}")
    public BaseResponse payOrderWithRocketMQ(
            @ApiParam(name = "orderNumber", value = "订单编号", required = true)
            @PathVariable("orderNumber")String orderNumber) {

        int count = this.orderPaymentService.payOrderWithRocketMQ(orderNumber);

        if (count == AppConsts.SUCCESS_COUNT) {
            return new BaseResponse().message("订单支付成功");
        } else {
            throw new ApplicationException(ResultCodeEnum.ORDER_PAY_ERROR);
        }
    }

    @ApiOperation("KafkaMQ版本 - 根据订单编号支付订单")
    @GetMapping("/success/kafka/{orderNumber}")
    public BaseResponse payOrderWithKafkaMQ(
            @ApiParam(name = "orderNumber", value = "订单编号", required = true)
            @PathVariable("orderNumber")String orderNumber) {

        int count = this.orderPaymentService.payOrderWithKafkaMQ(orderNumber);

        if (count == AppConsts.SUCCESS_COUNT) {
            return new BaseResponse().message("订单支付成功");
        } else {
            throw new ApplicationException(ResultCodeEnum.ORDER_PAY_ERROR);
        }
    }
}
