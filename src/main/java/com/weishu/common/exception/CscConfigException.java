package com.weishu.common.exception;


import com.weishu.common.enums.ResultCodeEnum;

import java.util.Date;

/**
 * @author lijianye Created on 17/1/5.
 */
public class CscConfigException extends Exception {
    private int code;

    final private Date timestamp;

    public int getCode() {
        return code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public CscConfigException(String message) {
        super(message);
        this.code = code;
        this.timestamp = new Date();
    }

    public CscConfigException(int code, String message) {
        this(message);
        this.code = code;
    }

    public CscConfigException(ResultCodeEnum resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }
}
