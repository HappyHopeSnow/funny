package com.weishu.constant;

import org.apache.commons.lang3.StringUtils;

public class OsTypeConstant {

	//表示Android和苹果
	public static final String ANDROID = "A";
	public static final String IPHONE = "I";
	public static final String PC = "P";
	
	//osType
	public static final String ISHE_ANDROID = "A";
	public static final String ISHE_IPHONE = "I";
	public static final String ISHE_PC = "P";
	
//	public static final String BEAUTY_ANDROID = "BA";
//	public static final String BEAUTY_IPHONE = "BI";
	
	public static final String CHINA_VOICE_ANDROID = "XZA";
	public static final String CHINA_VOICE_IPHONE = "XZI";
	
	public static final String CHINA_MAYDAY_ANDROID = "X2A";
	public static final String CHINA_MAYDAY_IPHONE = "X2I";
	
	public static final String CHINA_EXO_ANDROID = "X3A";
	public static final String CHINA_EXO_IPHONE = "X3I";
	
	public static final String CHINA_PSY_ANDROID = "X4A";
	public static final String CHINA_PSY_IPHONE = "X4I";
	
	public static String getOsType(String version) {
		if(StringUtils.isEmpty(version)) return ISHE_IPHONE;
		
		String[] arr = version.split("_");
		String osType = arr[0];
		return osType;
	}
	
	public static final int PLATFORM_UNKNOW = 0;
	public static final int PLATFORM_ANDROID = 1;
	public static final int PLATFORM_IPHONE = 2;
	public static final int PLATFORM_PC = 3;
}
