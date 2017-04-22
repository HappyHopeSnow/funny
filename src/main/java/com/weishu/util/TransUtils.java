package com.weishu.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Description: <br>
 * 封装百度翻译工具类
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/19 上午7:54
 */
public class TransUtils {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20170418000045062";
    private static final String SECURITY_KEY = "y0YMfT6_lWIidofV73EC";

    /**
     * 英文转中文
     * @param query 要转化的英文
     * @param
     * @return
     */
    public static String en2zh(String query) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String data = api.getTransResult(query, "en", "zh");
        return parseJson(data);
    }

    /**
     * 解析json结构，只返回结果
     * @param data
     *
     {
        "from":"en",
        "to":"zh",
        "trans_result":[{
                    "src":"lemon",
                    "dst":"柠檬"
                }]
    }
     *
     * @return
     */
    public static String parseJson(String data) {
//        data = "{\n" +
//                "    \"from\":\"en\",\n" +
//                "    \"to\":\"zh\",\n" +
//                "    \"trans_result\":[\n" +
//                "        {\n" +
//                "            \"src\":\"lemon\",\n" +
//                "            \"dst\":\"柠檬\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
        JSONObject jsonObject = JSONObject.parseObject(data);

        JSONArray array = jsonObject.getJSONArray("trans_result");
        return array.getJSONObject(0).getString("dst");
    }

    public static void main(String[] args) {
//        TransUtils.parseJson("");

        String test = TransUtils.en2zh("hello");
        System.out.println(test);
    }
}
