package com.qd.base;

import java.io.Serializable;

/**
 * 分页信息
 * @author RyanHuang
 * @Version 1.0
 * @date 2014年10月14日 下午7:32:02
 * @email huang.bowei@trs.com.cn
 */
public class PageParam implements Serializable {

	private static final long serialVersionUID = 1373169532787588008L;
	
	/**
	 * 默认当前页数
	 */
	public static final int DEFAULT_PAGE = 1;
	/**
	 * 默认分页大小
	 */
	public static final int DEFAULT_ROWS = 20;
	public static final String DIR_ASC = "ASC";
	public static final String DIR_DESC = "DESC";

	private int rows = DEFAULT_ROWS;
	private int page = DEFAULT_PAGE;
	private String sort;
	private String dir = DIR_ASC;
	
	public Integer getRows() {
		return this.rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setRows(Integer rows) {
		if ( null != rows )
			this.rows = rows.intValue();
	}
	public Integer getPage() {
		return this.page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setPage(Integer page) {
		if ( null != page )
			this.page = page.intValue();
	}
	public String getSort() {
		return this.sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return this.dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public int getStartPos() {
		return (this.page-1) * this.rows;
	}
}
