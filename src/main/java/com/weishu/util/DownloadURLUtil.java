package com.weishu.util;

public class DownloadURLUtil {
	
	private static String ESCAPE_URL;
	private static String PACKAGE_DOWNLOAD_URL;
	private static String PACKAGE_IMG_URL;
	
	public static final String PACKAGE_DOWNLOAD = "download";
	public static final String PACKAGE_QCODE = "qrcodeimg";
	public static final String ESCAPE_QCODE = "espimg";
	public static final String ESCAPE_QCODE_NEW = "espimgnew";
	public static final String APPSTORE_QCODE = "appstoreimg";
	public static final String PACKAGE_ICON = "icon";
	
	
	static {

		PropertyConfig propertyConfig = PropertyConfig.getInstance();
		ESCAPE_URL = propertyConfig.getString("appleEscapeUrl");
		PACKAGE_DOWNLOAD_URL = propertyConfig.getString("packagedownload");
		PACKAGE_IMG_URL = propertyConfig.getString("packageimgs");
	}
	
	//包的下载地址
	public static String getURL(String packageName, String extension) {
		
		String packageURL = PACKAGE_DOWNLOAD_URL+PACKAGE_DOWNLOAD+"/" + packageName + "." + extension;
		
		return packageURL;
	}
	
	//二维码的地址，对应包的下载地址
	public static String getImgURL(String packageName, int width, String extension) {
		
		String imgURL = PACKAGE_IMG_URL+PACKAGE_QCODE+"/" + width + "/" + packageName + "." + extension;
		
		return imgURL;
	}
	
	//二维码的地址，对应越狱下载地址
	public static String getEscapeImgURL(String packageName, int width, String extension) {
		String imgURL = PACKAGE_IMG_URL+ESCAPE_QCODE+"/" + width + "/" + packageName + "." + extension;
		return imgURL;
	}
	
	//二维码的地址，对应越狱下载地址New
	public static String getEscapeNewImgURL(String packageName, int width, String extension) {
		String imgURL = PACKAGE_IMG_URL+ESCAPE_QCODE_NEW+"/" + width + "/" + packageName + "." + extension;
		return imgURL;
	}
	
	//AppStore下载的的二维码地址
	public static String getAppStoreImg(Long appId, int width, String extension) {
		
		String imgURL = PACKAGE_IMG_URL+APPSTORE_QCODE+"/" + width + "/" + appId + "." + extension;
		
		return imgURL;
	}
	
	//越狱安装时需要的图标地址
	public static String getIconURL(String osTypeCode) {
		String iconURL = PACKAGE_IMG_URL+PACKAGE_ICON+"/" + osTypeCode + ".png";
		return iconURL;
	}
	
	//越狱安装的地址
	public static String getEscapeURL(String packageName) {
		String escapeURL = ESCAPE_URL + "?v=" + packageName;
		return escapeURL;
	}
	
	//越狱安装的地址New
	public static String getEscapeNewURL(String packageName) {
		String escapeURL = ESCAPE_URL + "v/" + packageName;
		return escapeURL;
	}
	
	//任意一个字符串所表示的二维码的IMG地址
	public static String getStringImgURL(String str, int width) {
		str = EncodingUtil.encodeURIComponent(str);
		str = EncodingUtil.encodeURIComponent(str);
		String imgURL = PACKAGE_DOWNLOAD_URL + "img/" + width + "/" + str + ".jpg";
		return imgURL;
	}
	
}
