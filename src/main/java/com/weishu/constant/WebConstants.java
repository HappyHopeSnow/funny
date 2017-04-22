package com.weishu.constant;

/**
 * web的常量
 * Created by Jackie on 2015/5/11.
 * Email : chenxinhua@ishehui.com
 */
public interface WebConstants {
    String SESSION_USER = "_session_user";
    String SYS_SESSION_USER = "_sys_session_user";
    int COOKIE_MAX_TIME = 60*60*24*7;
    String UID_COOKIE = "UID";//KOOKIE中的uid字段（大写）
    String UID_PARAMS = "uid";//参数中的uid字段（小写）
    String TOKEN_COOKIE = "TOKEN";//KOOKIE中的uid字段（大写）
    String TOKEN_PARAMS = "token";//参数中的uid字段（小写）
    String DEVICE = "DEVICE";//设备串号

}
