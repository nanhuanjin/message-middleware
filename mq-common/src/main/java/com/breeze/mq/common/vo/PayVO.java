package com.breeze.mq.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author breeze
 * @date 2020/6/1
 */
@Data
@ApiModel("订单支付VO对象")
public class PayVO {

    @ApiModelProperty("订单名称")
    private String orderName;

    @ApiModelProperty("订单编号")
    private String orderNumber;

    @ApiModelProperty("支付金额")
    private String money;

    @ApiModelProperty("商品描述")
    private String content;
}
