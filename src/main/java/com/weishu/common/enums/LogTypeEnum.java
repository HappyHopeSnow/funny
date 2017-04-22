package com.weishu.common.enums;

/**
 * Created by jianglei on 17/2/6.
 */
public enum LogTypeEnum {

    /** 参数异常 */
    PARAMETER_ERROR(" [Parameter Error] "),

    /** 转换异常 */
    TRANSFORM_ERROR(" [Transform Error] "),
    ;

    public String code;

    LogTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
