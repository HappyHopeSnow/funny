package com.weishu.common.exception;


import com.weishu.common.enums.ResultCodeEnum;

import java.util.Date;

/**
 * Created by lixuemei on 17/2/14.
 */
public class ParamsValidationException extends RuntimeException{

    private Integer code;

    final private Date timestamp;

    public int getCode() {
        return code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public ParamsValidationException(String message) {
        super(message);
        this.code = ResultCodeEnum.PARAMETER_ERROR.getCode();
        this.timestamp = new Date();
    }

    public ParamsValidationException(Integer code, String message) {
        this(message);
        this.code = code;
    }

    public ParamsValidationException(ResultCodeEnum resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }
}
