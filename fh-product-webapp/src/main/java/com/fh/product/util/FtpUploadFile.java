package com.fh.product.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FtpUploadFile {

	/**
	 * <pre>
	 * uploadFile(这里用一句话描述这个方法的作用)   
	 * 创建人：onlyShangfeng 1916015158@qq.com   
	 * 创建时间：2018年9月17日 上午10:30:27    
	 * 修改人：onlyShangfeng 1916015158@qq.com      
	 * 修改时间：2018年9月17日 上午10:30:27    
	 * 修改备注： 
	 * &#64;param filePath 要保存的文件路径
	 * &#64;param filename  文件名称一定要重命名
	 * &#64;param file 上传的文件
	 * &#64;return
	 * </pre>
	 */
	public static Map uploadFile(String filePath, MultipartFile file) {

		String filename = getFileName(file);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = false;
		FtpBean ftpbean = new FtpBean();
		// 创建ftp的客户端
		FTPClient ftp = new FTPClient();
		// 设置编码
		ftp.setControlEncoding("GBK");
		try {
			InputStream input = file.getInputStream();
			int reply;
			// 创建连接
			ftp.connect(ftpbean.getHost(), ftpbean.getPort());// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(ftpbean.getUser(), ftpbean.getPassword());// 登录
			// 验证登录是否成功
			reply = ftp.getReplyCode();
			// 根据返回的编码值判断是否登录成功。
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				map.put("ok", result);
				return map;
			}
			 ftp.enterLocalPassiveMode();
			// 获取根目录
			String basePath = ftpbean.getPath();
			// 切换到上传目录
			// 1916015158/20180917/文件名
			// linux下动态循环创建多层文件夹
			if (!ftp.changeWorkingDirectory(basePath + filePath)) {
				// 如果目录不存在创建目录
				String[] dirs = filePath.split("/");
				String tempPath = basePath;
				for (String dir : dirs) {
					if (null == dir || "".equals(dir))
						continue;
					tempPath += "/" + dir;
					if (!ftp.changeWorkingDirectory(tempPath)) {
						if (!ftp.makeDirectory(tempPath)) {
							map.put("ok", result);
							return map;
						} else {
							ftp.changeWorkingDirectory(tempPath);
						}
					}
				}
			}
			// 设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			// 上传文件
			if (!ftp.storeFile(filename, input)) {
				map.put("ok", result);
				return map;
			}
			input.close();
			ftp.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		map.put("ok", result);
		map.put("url", filePath + "/" + filename);
		return map;
	}

	public static String getFileName(MultipartFile file) {
		// 文件重命名
		// 获取文件的真是名称
		String fname = file.getOriginalFilename();
		// 重命名
		String namesufix = fname.substring(fname.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		String newfilename = uuid + namesufix;
		return newfilename;
	}
}
