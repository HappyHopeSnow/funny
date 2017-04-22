package com.weishu.dynamicDB;

/**
 * Created by zhangshijie on 2015/6/9.
 */
public class DatabaseContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
	private static final ThreadLocal<Boolean> forceMaster = new ThreadLocal<>();

	public static void setDataSource(String sourceName) {
		contextHolder.set(sourceName);
	}

	public static String getDataSource() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}

	public static Boolean isForceMaster() {
		return forceMaster.get()==null?false:forceMaster.get();
	}
	public static void setForceMaster(Boolean isForce) {
		forceMaster.set(isForce);
	}
}
