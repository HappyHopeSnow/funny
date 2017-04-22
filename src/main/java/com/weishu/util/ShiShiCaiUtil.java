package com.weishu.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ShiShiCaiUtil {

	/**
	 *
	 * 根据时间获取对应的期号
	 */
	public static String getExpect(Date time) {
		/*开奖时间：白天10点至22点 夜场22点至凌晨2点
		开奖频率：白天10分钟 夜场5分钟
		每日期数：白天72期，夜场48期，共120期
		返奖率：50%0
		*/

		//判断时间是在哪个时间段
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		String nowTime = df.format(time);
		System.out.println("nowTime = " + nowTime);

		String strDateYear = nowTime.substring(0,4);
		String strDateMonth = nowTime.substring(5,7);
		String strDateDay = nowTime.substring(8,10);

		int strDateH = Integer.parseInt(nowTime.substring(11,13));
		int strDateM = Integer.parseInt(nowTime.substring(14,16));
		int strDateS = Integer.parseInt(nowTime.substring(17, 19));
		int expect;

		//判断时是在哪个区间
		if(strDateH >= 0 && strDateH < 2) {
			//在1-23期之间
			if(strDateM > 0) {
				//12-23
				expect = 12 + strDateS / 5;
			}else {
				if(strDateS == 00) {
					expect = 120;
				}
				//1-11
				expect = strDateS/5;
			}

		}else if (strDateH <= 22) {
			//在24-96期之间
			expect = ((strDateH - 10) * 60 + strDateM) / 10 + 24;

		}else {
			//在97-120之间

			if(strDateM >= 23) {
				//108-120
				expect = 108 + strDateS / 5;
			}else {
				//97-107
				expect = 96 + strDateS/5;
			}
		}

		if(expect < 100) {
			return strDateYear + strDateMonth + strDateDay + "0" + expect;
		}

		return strDateYear + strDateMonth + strDateDay + expect;
	}

	public static void main(String[] args) {
		System.out.println(getExpect(new Date()));
	}

}
