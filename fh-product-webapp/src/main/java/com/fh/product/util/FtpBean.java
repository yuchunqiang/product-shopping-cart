package com.fh.product.util;

/**
 * All rights Reserved
 * 
 * @Title: FtpBean.java
 * @Package com.fh.util
 * @Description: TODO(用一句话描述该文件)
 * @author: 郑州飞狐
 * @date: 2018年5月15日 上午9:53:28
 * @version V1.0
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved.
 * @注意: 本内容仅限于郑州飞狐，禁止外泄以及用于其他的商业目。
 */
public class FtpBean {

	private String	host;
	private Integer	port;
	private String	user;
	private String	password;
	private String	path;
	private String nginx;

	/**
	 * 改成单例
	 * 
	 * <pre>
	 * 创建一个新的实例 FtpBean.
	 * </pre>
	 */
	public FtpBean() {
		this.host = UtilProperties.getProperty("ftp.host");
		this.port = (Integer.valueOf(UtilProperties.getProperty("ftp.port")));
		this.user = UtilProperties.getProperty("ftp.user");
		this.password = UtilProperties.getProperty("ftp.password");
		this.path = UtilProperties.getProperty("ftp.path");
		this.nginx= UtilProperties.getProperty("nginx.host");
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNginx() {
		return nginx;
	}

	public void setNginx(String nginx) {
		this.nginx = nginx;
	}

}
