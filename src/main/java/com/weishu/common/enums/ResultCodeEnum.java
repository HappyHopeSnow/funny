package com.weishu.common.enums;

/**
 * Created by lianle on 17/1/4.
 */
public enum ResultCodeEnum {
    /**
     * 成功
     **/
    SUCCESS(200, "成功"),

    /**
     * 400  失败（客户端原因造成）
     */
    PARAMETER_ERROR(400, "参数错误"),

    /**
     * 401  失败（客户端原因造成）
     */
    PARAMETER_ERROR_CONVERT(401, "参数转换异常，请确认参数类型"),


    /**
     * 401  失败（客户端原因造成）
     */
    PARAMETER_ERROR_MISSING(402, "参数丢失或参数名错误，请重试！"),

    /**
     * 500 失败（服务端原因造成）
     */
    ERROR(500, "服务器内部异常"),

    /***********************业务相关*******************************************************/


    /**
     * 501 失败 session丢失，需重新登录
     */
    SESSION_LOGOUT(501, "操作超时，请重新登录");

    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
