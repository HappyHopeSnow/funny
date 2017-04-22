package com.weishu.common.vo;


import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 开放API所使用的统一的响应数据格式
 * */
public class UnifiedResponse {

	/** 响应码（必选字段）*/
	private int status;
	
	/** 响应码提示信息*/
	private String message;
	
	/** 附件信息，其他拓展信息，可选字段，一般可以是MAP*/
	private Object data;
	
	public UnifiedResponse() {
		this.status = ResultCodeEnum.SUCCESS.getCode();
		this.message = ResultCodeEnum.SUCCESS.getMsg();
	}
	
	public UnifiedResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public UnifiedResponse(Object data) {
		this.status = ResultCodeEnum.SUCCESS.getCode();
		this.message = ResultCodeEnum.SUCCESS.getMsg();

		//校验id返回
		if (data instanceof Long) {
			Map<String, Object> attachment = new HashMap<>();
			attachment.put("id", data);
			this.data = attachment;
		}else {
			this.data = data;
		}
	}

	public UnifiedResponse(PageInfo pageInfo) {
		this.status = ResultCodeEnum.SUCCESS.getCode();
		this.message = ResultCodeEnum.SUCCESS.getMsg();
		Map<String, Object> attachment = new HashMap<>();
		attachment.put("items", pageInfo.getList());
		attachment.put("totalCount", pageInfo.getTotal());
		this.data = attachment;
	}

	public UnifiedResponse(int status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public UnifiedResponse(ResultCodeEnum resultCodeEnum) {
		this.status = resultCodeEnum.getCode();
		this.message = resultCodeEnum.getMsg();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}