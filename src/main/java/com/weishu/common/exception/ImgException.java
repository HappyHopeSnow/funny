package com.weishu.common.exception;

import java.util.Date;

/**
 * Description: <br>
 * 图片异常
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/9 下午10:32
 */
public class ImgException extends RuntimeException {

    private int code;
    private String msg;
    final private Date timestamp;

    public ImgException(String message) {
        super(message);
        this.code = code;
        this.timestamp = new Date();
    }
}
