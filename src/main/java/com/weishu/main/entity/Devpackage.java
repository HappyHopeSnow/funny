package com.weishu.main.entity;

import java.io.Serializable;
import java.util.Date;

public class Devpackage implements Serializable {
    private Long id;

    private Long ostypeid;

    private Long devversionid;

    private Long channeluid;

    private Integer status;

    private String name;

    private String path;

    private String descrp;

    private Integer updatetype;

    private Long updateid;

    private String updatedescrp;

    private Date createtime;

    private Date modifiedtime;

    private Integer isnew;

    private Integer type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOstypeid() {
        return ostypeid;
    }

    public void setOstypeid(Long ostypeid) {
        this.ostypeid = ostypeid;
    }

    public Long getDevversionid() {
        return devversionid;
    }

    public void setDevversionid(Long devversionid) {
        this.devversionid = devversionid;
    }

    public Long getChanneluid() {
        return channeluid;
    }

    public void setChanneluid(Long channeluid) {
        this.channeluid = channeluid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp == null ? null : descrp.trim();
    }

    public Integer getUpdatetype() {
        return updatetype;
    }

    public void setUpdatetype(Integer updatetype) {
        this.updatetype = updatetype;
    }

    public Long getUpdateid() {
        return updateid;
    }

    public void setUpdateid(Long updateid) {
        this.updateid = updateid;
    }

    public String getUpdatedescrp() {
        return updatedescrp;
    }

    public void setUpdatedescrp(String updatedescrp) {
        this.updatedescrp = updatedescrp == null ? null : updatedescrp.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Integer getIsnew() {
        return isnew;
    }

    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}