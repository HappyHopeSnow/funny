package com.weishu.constant;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午10:16
 */
public enum ShowEnum {

    NOT_DELETE((byte) 0, "展示"),
    DELETE((byte) 1, "不展示");

    private byte code;
    private String value;


    ShowEnum(byte code, String value) {
        this.code = code;
        this.value = value;
    }


    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
