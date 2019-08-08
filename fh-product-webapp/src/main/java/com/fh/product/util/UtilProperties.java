package com.fh.product.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
  * All rights Reserved
  * @Title:  UtilProperties.java   
  * @Package com.fh.util   
  * @Description:    TODO(用一句话描述该文件)   
  * @author: 郑州飞狐    
  * @date:   2018年5月15日 上午9:43:54   
  * @version V1.0 
  * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
  * @注意: 本内容仅限于郑州飞狐，禁止外泄以及用于其他的商业目。
 */
public class UtilProperties {

	private static final Logger logger = LoggerFactory.getLogger(UtilProperties.class);
	private static Properties props;
	static {
		loadProps();
	}

	synchronized static private void loadProps() {
		logger.info("开始加载properties文件内容.......");
		props = new Properties();
		InputStream in = null;
		try {
			in = UtilProperties.class.getClassLoader().getResourceAsStream("config.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			logger.error("jdbc.properties文件未找到");
		} catch (IOException e) {
			logger.error("出现IOException");
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("jdbc.properties文件流关闭出现异常");
			}
		}
		logger.info("加载properties文件内容完成...........");
		logger.info("properties文件内容：" + props);
	}

	public static String getProperty(String key) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		if (null == props) {
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}

}
