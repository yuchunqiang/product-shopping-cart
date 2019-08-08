/** 
 * <pre>项目名称:hibernate_hql 
 * 文件名称:PageBean.java 
 * 包名:com.fh.bean 
 * 创建日期:2018-7-19上午9:56:31 
 * Copyright (c) 2018, 1378024757@qq.com All Rights Reserved.</pre> 
 */  
package com.fh.product.util;

import java.util.List;

/** 
 * <pre>项目名称：hibernate_hql    
 * 类名称：PageBean    
 * 类描述：    
 * 创建人：FairyYing  1378024757@qq.com    
 * 创建时间：2018-7-19 上午9:56:31    
 * 修改人：FairyYing  1378024757@qq.com     
 * 修改时间：2018-7-19 上午9:56:31    
 * 修改备注：       
 * @version </pre>    
 */
public class PageBean<T>{
	//总条数
	private Integer totalcount;
	//总页数
	private Integer pagesum;
	//每页条数
	private Integer pagesize=5;
	//当前页
	private Integer pagenow=1;
	//开始下标
	private Integer startIndax;
	//结束下标
	private Integer endIndex;
	//存放数据的list
	private List<T>list;
	
	/**
	 * <pre>getTotalcont(计算分页需要的数据)   
	 * 创建人：FairyYing  1378024757@qq.com   
	 * 创建时间：2018-7-19 下午12:06:51    
	 * 修改人：FairyYing  1378024757@qq.com     
	 * 修改时间：2018-7-19 下午12:06:51    
	 * 修改备注： 
	 * @return</pre>
	 */
	/*
	 * calculate计算
	 */
	public void calculate(){
	//remainder 余数	= 计算出总页数  总条数除以每页条数 
		 int remainder = this.totalcount % this.pagesize;
		 //如果余数里的总页数等于0
	        if (remainder == 0) {
	        	//总页数就等于总条数乘以每页条数 
	            this.pagesum = this.totalcount / this.pagesize;
	            //否则总页数就等于总条数乘以每页条数多出来的就再加一页 
	        } else {
	            this.pagesum = this.totalcount / this.pagesize + 1;
	        }
	     // 计算开始下标  当前页减1乘以每页条数 
	     this.startIndax= (this.pagenow - 1) * this.pagesize;
	     // 计算结束下标  当前页乘以每页条数 
	     this.endIndex = this.pagenow * this.pagesize;
	    //计算总页数
	    //this.pagesum=this.totalcount%this.pagesize==0?(this.totalcount / this.pagesize):(this.totalcount / this.pagesize + 1);
	}
	
	public Integer getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
	public Integer getPagesum() {
		return pagesum;
	}
	public void setPagesum(Integer pagesum) {
		this.pagesum = pagesum;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getPagenow() {
		return pagenow;
	}
	public void setPagenow(Integer pagenow) {
		this.pagenow = pagenow;
	}
	public Integer getStartIndax() {
		return startIndax;
	}
	public void setStartIndax(Integer startIndax) {
		this.startIndax = startIndax;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
