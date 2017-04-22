package com.weishu.main.model;

import com.weishu.main.entity.Application;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 
 * @author Lee
 *
 * 2012-11-7 16:58:30
 */
public class DownloadModel implements Serializable{
	private String iphoneVersion;
	private String androidVersion;
	
	private String iosIdentify;
	private String androidIdentify;
	
	private Long appId;
	private String name;
	//android下载地址
	private String androidUrl;
	//two-dimension code
	//android二维码
	private String androidTdc;
	//iphone下载地址(越狱)
	private String iphoneUrl;
	//iphone二维码(越狱)
	private String iphoneTdc;
	//iphone下载地址(未越狱)
	private String appStoreUrl;
	//iphone二维码(未越狱)
	private String appStoreTdc;
	//iphone的ipa
	private String iphoneIpaUrl;
	//描述
	private String descrp;
	//启动页面地址
	private String startPicUrl;
	//appLogo
	private String appLogoUrl;
	//下载页背景
	private Long bcover;
	
	public DownloadModel() {
	}
	
	public DownloadModel(Application application) {
		if(null == application) {
			return ;
		}
		this.appId = application.getId();
		this.name = application.getName();
		this.appStoreUrl = application.getAppstore();
		this.descrp = application.getDescrp();
		this.bcover = application.getBcover();
		this.iosIdentify = application.getIosidentify();
		this.androidIdentify = application.getIdentify();
	}
	
	public String getIphoneVersion() {
		return iphoneVersion;
	}

	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setIphoneVersion(String iphoneVersion) {
		this.iphoneVersion = iphoneVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}
	public String getIosIdentify() {
		return iosIdentify;
	}

	public void setIosIdentify(String iosIdentify) {
		this.iosIdentify = iosIdentify;
	}

	public String getAndroidIdentify() {
		return androidIdentify;
	}

	public void setAndroidIdentify(String androidIdentify) {
		this.androidIdentify = androidIdentify;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAndroidUrl() {
		return androidUrl;
	}
	public void setAndroidUrl(String androidUrl) {
		this.androidUrl = androidUrl;
	}
	public String getAndroidTdc() {
		return androidTdc;
	}
	public void setAndroidTdc(String androidTdc) {
		this.androidTdc = androidTdc;
	}
	public String getIphoneUrl() {
		return iphoneUrl;
	}
	public void setIphoneUrl(String iphoneUrl) {
		this.iphoneUrl = iphoneUrl;
	}
	public String getIphoneTdc() {
		return iphoneTdc;
	}
	public void setIphoneTdc(String iphoneTdc) {
		this.iphoneTdc = iphoneTdc;
	}

	public String getAppStoreUrl() {
		return appStoreUrl;
	}
	public void setAppStoreUrl(String appStoreUrl) {
		this.appStoreUrl = appStoreUrl;
	}
	public String getAppStoreTdc() {
		return appStoreTdc;
	}
	public void setAppStoreTdc(String appStoreTdc) {
		this.appStoreTdc = appStoreTdc;
	}
	public String getIphoneIpaUrl() {
		return iphoneIpaUrl;
	}
	public void setIphoneIpaUrl(String iphoneIpaUrl) {
		this.iphoneIpaUrl = iphoneIpaUrl;
	}

	public String getDescrp() {
		return descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	public boolean getHasAppStore() {
		return StringUtils.isNotEmpty(appStoreUrl);
	}

	public String getStartPicUrl() {
		return startPicUrl;
	}

	public void setStartPicUrl(String startPicUrl) {
		this.startPicUrl = startPicUrl;
	}

	public String getAppLogoUrl() {
		return appLogoUrl;
	}

	public void setAppLogoUrl(String appLogoUrl) {
		this.appLogoUrl = appLogoUrl;
	}

	public Long getBcover() {
		return bcover;
	}

	public void setBcover(Long bcover) {
		this.bcover = bcover;
	}
	
	public boolean hasBcover() {
		return this.bcover!=null && this.bcover>0L;
	}

}
