package com.fh.product.response;

public enum ResponseEnum {

	SUCCESS(10000,"访问成功"),
	ADDUSER(10002,"注册成功"),
	ERROR(10001,"访问失败"),
	USER_ALREADY_EXIST(50001,"用户名已存在"),
	IDENTIFYING_CODE(50002,"验证码输入错误"),
	USER_NO_EXIST(50003,"登录账号不存在请注册"),
	PASSWORD_ERROR(50004,"密码错误"),
	ACCOUNT_LOCKED(50005,"账号锁定，请明天再试");
	
	
	private Integer code;
	private String msg;
	
	
	
	private ResponseEnum() {
	}
	
	private ResponseEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
