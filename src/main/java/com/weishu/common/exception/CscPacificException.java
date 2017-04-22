package com.weishu.common.exception;

import com.weishu.common.enums.ResultCodeEnum;

import java.util.Date;

/**
 * @author lijianye Created on 17/1/5.
 */
public class CscPacificException extends Exception {
    private int code;

    final private Date timestamp;

    public int getCode() {
        return code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public CscPacificException(String message) {
        super(message);
        this.code = code;
        this.timestamp = new Date();
    }

    public CscPacificException(int code, String message) {
        this(message);
        this.code = code;
    }

    public CscPacificException(ResultCodeEnum resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }
}
