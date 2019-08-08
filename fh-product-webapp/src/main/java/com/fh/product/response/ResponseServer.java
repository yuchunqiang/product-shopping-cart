package com.fh.product.response;

public class ResponseServer {

	private Integer code;
	private String msg;
	private Object data;
	
	
	public static ResponseServer success(){
		return new ResponseServer(200, "成功");
	}
	
	public static ResponseServer success(Object data){
		return new ResponseServer(200, "成功",data);
	}
	
	public static ResponseServer error(){
		return new ResponseServer(-1, "失败");
	}
	
	public static ResponseServer error(Integer code,String msg){
		return new ResponseServer(code, msg);
	}
	
	public static ResponseServer error(ResponseEnum responseEnum){
		return new ResponseServer(responseEnum.getCode(),responseEnum.getMsg());
	}
	
	private  ResponseServer(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	private ResponseServer(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
