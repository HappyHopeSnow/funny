package com.weishu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jackie on 2015/9/25.
 * Email : chenxinhua@ishehui.com
 * 获取或存储投票号码的工具类
 */
public class VoteNumberUtils {
    private VoteNumberUtils(){}
    private static final String[] VOTE_NUMBERS = new String[10000];
    static {
        for (int i = 0; i < 10000; i++) {
            VOTE_NUMBERS[i] = String.valueOf(i);
        }
    }

    /**
     * 获得投票号
     * @param quantity
     * @return
     */
    public static String[] achieveNumber(int quantity) {
        return Arrays.copyOfRange(VOTE_NUMBERS, 0, quantity);
    }
}
