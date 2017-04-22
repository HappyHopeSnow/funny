package com.weishu.dynamicDB;

/**
 * 数据源名称
 * Created by Jackie on 2015/6/16.
 * Email : chenxinhua@ishehui.com
 */
public enum  DataSourceName {
    MASTER("master"), SLAVE("slave");

    private final String value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    DataSourceName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
