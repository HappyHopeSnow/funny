package com.weishu.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private String appid;
    private String securityKey;

    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }

    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        return HttpGet.get(TRANS_API_HOST, params);
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20170418000045062";
    private static final String SECURITY_KEY = "y0YMfT6_lWIidofV73EC";
    private static final String PYTHON_FILE_PATH = "";

    public static void main(String[] args) throws IOException {

        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "lemon";
//        System.out.println(api.getTransResult(query, "auto", "en"));
        String result = api.getTransResult(query, "en", "zh");
        System.out.println("result = " + result);



    }

}
