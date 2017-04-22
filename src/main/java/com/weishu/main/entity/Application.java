package com.weishu.main.entity;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    private Long id;

    private String name;

    private String prename;

    private String identify;

    private String iosidentify;

    private String appstore;

    private Integer status;

    private Date createtime;

    private String extinfo;

    private String descrp;

    private Long appicon;

    private Long banner;

    private String sinakey;

    private String sinasecsecret;

    private String qqkey;

    private String qqsecret;

    private String umengkey;

    private String weixinkey;

    private String thirdaurl;

    private Integer language;

    private String fbkey;

    private String fbsecret;

    private String twkey;

    private String twsecret;

    private String tag;

    private Long cover;

    private Long bcover;

    private String umengpushkey;

    private String umengpushsecret;

    private String sinaid;

    private String sinapassword;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename == null ? null : prename.trim();
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public String getIosidentify() {
        return iosidentify;
    }

    public void setIosidentify(String iosidentify) {
        this.iosidentify = iosidentify == null ? null : iosidentify.trim();
    }

    public String getAppstore() {
        return appstore;
    }

    public void setAppstore(String appstore) {
        this.appstore = appstore == null ? null : appstore.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getExtinfo() {
        return extinfo;
    }

    public void setExtinfo(String extinfo) {
        this.extinfo = extinfo == null ? null : extinfo.trim();
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp == null ? null : descrp.trim();
    }

    public Long getAppicon() {
        return appicon;
    }

    public void setAppicon(Long appicon) {
        this.appicon = appicon;
    }

    public Long getBanner() {
        return banner;
    }

    public void setBanner(Long banner) {
        this.banner = banner;
    }

    public String getSinakey() {
        return sinakey;
    }

    public void setSinakey(String sinakey) {
        this.sinakey = sinakey == null ? null : sinakey.trim();
    }

    public String getSinasecsecret() {
        return sinasecsecret;
    }

    public void setSinasecsecret(String sinasecsecret) {
        this.sinasecsecret = sinasecsecret == null ? null : sinasecsecret.trim();
    }

    public String getQqkey() {
        return qqkey;
    }

    public void setQqkey(String qqkey) {
        this.qqkey = qqkey == null ? null : qqkey.trim();
    }

    public String getQqsecret() {
        return qqsecret;
    }

    public void setQqsecret(String qqsecret) {
        this.qqsecret = qqsecret == null ? null : qqsecret.trim();
    }

    public String getUmengkey() {
        return umengkey;
    }

    public void setUmengkey(String umengkey) {
        this.umengkey = umengkey == null ? null : umengkey.trim();
    }

    public String getWeixinkey() {
        return weixinkey;
    }

    public void setWeixinkey(String weixinkey) {
        this.weixinkey = weixinkey == null ? null : weixinkey.trim();
    }

    public String getThirdaurl() {
        return thirdaurl;
    }

    public void setThirdaurl(String thirdaurl) {
        this.thirdaurl = thirdaurl == null ? null : thirdaurl.trim();
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getFbkey() {
        return fbkey;
    }

    public void setFbkey(String fbkey) {
        this.fbkey = fbkey == null ? null : fbkey.trim();
    }

    public String getFbsecret() {
        return fbsecret;
    }

    public void setFbsecret(String fbsecret) {
        this.fbsecret = fbsecret == null ? null : fbsecret.trim();
    }

    public String getTwkey() {
        return twkey;
    }

    public void setTwkey(String twkey) {
        this.twkey = twkey == null ? null : twkey.trim();
    }

    public String getTwsecret() {
        return twsecret;
    }

    public void setTwsecret(String twsecret) {
        this.twsecret = twsecret == null ? null : twsecret.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Long getCover() {
        return cover;
    }

    public void setCover(Long cover) {
        this.cover = cover;
    }

    public Long getBcover() {
        return bcover;
    }

    public void setBcover(Long bcover) {
        this.bcover = bcover;
    }

    public String getUmengpushkey() {
        return umengpushkey;
    }

    public void setUmengpushkey(String umengpushkey) {
        this.umengpushkey = umengpushkey == null ? null : umengpushkey.trim();
    }

    public String getUmengpushsecret() {
        return umengpushsecret;
    }

    public void setUmengpushsecret(String umengpushsecret) {
        this.umengpushsecret = umengpushsecret == null ? null : umengpushsecret.trim();
    }

    public String getSinaid() {
        return sinaid;
    }

    public void setSinaid(String sinaid) {
        this.sinaid = sinaid == null ? null : sinaid.trim();
    }

    public String getSinapassword() {
        return sinapassword;
    }

    public void setSinapassword(String sinapassword) {
        this.sinapassword = sinapassword == null ? null : sinapassword.trim();
    }

}