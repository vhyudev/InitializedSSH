package com.lxtech.ssh.vo;
/**
 * 提示信息
 * @author Administrator
 *
 */
public class MessegeDto {
	/**
	 * 业务数据
	 */
	Object data;
	/**
	 * 提示消息
	 */
	String message;
	/**
	 * "0"代表成功
	 * "1"代表不成功
	 */
	String status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
