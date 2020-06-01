package com.breeze.mq.common.exception;

import com.breeze.mq.common.result.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author breeze
 * @date 2020/6/1
 */
@Data
@ApiModel(value = "全局异常")
public class ApplicationException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private String code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public ApplicationException(String code, String message) {
        super(message);
        this.code=code;
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public ApplicationException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "ApplicationException{" +
                "code: " + code +
                ", message: " + this.getMessage() +
                '}';
    }
}
