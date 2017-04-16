package com.qd.base;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author RyanHuang
 * @Version 1.0
 * @date 2014年10月14日 下午7:28:36
 * @email huang.bowei@trs.com.cn
 */
public class Page<T extends IBaseModel <?extends Serializable>> implements Serializable {

	private static final long serialVersionUID = 6327299722955858734L;
	
	private int total;
	private List<T> datas;
	private int pageIndex;
	private int pageSize;
	
	public Page(int total, List<T> datas, int pageIndex, int pageSize) {
		super();
		this.total = total;
		this.datas = datas;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	
	public Page() {}
	
	public int getTotal() {
		return this.total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getDatas() {
		return this.datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPageIndex() {
		return this.pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return this.pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		int totalPage = ((total%pageSize)!=0) ? ((total/pageSize)+1) : (total/pageSize);
		return (totalPage<=0) ? 1 : totalPage;
	}
}
