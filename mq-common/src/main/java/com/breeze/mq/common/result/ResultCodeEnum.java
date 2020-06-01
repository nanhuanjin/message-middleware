package com.breeze.mq.common.result;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author breeze
 * @date 2020/6/1
 *
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("全局状态码")
public enum ResultCodeEnum {

    SUCCESS("00000", "成功"),
    UNKNOWN_REASON("B4001", "未知错误"),

    ORDER_PAY_ERROR("C4000", "订单支付异常");

    private String code;

    private String message;
}
