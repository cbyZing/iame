package com.qd.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface ILogicalDeletable<ID extends Serializable> extends IBaseModel<ID>{
	
	/**
	 * 标识是否逻辑删除该对象
	 * @param del
	 */
	void setLogicalDelete(boolean del);
	/**
	 * 判断对象是否被逻辑删除
	 * @return
	 */
	@Column(name="ISDEL")
	boolean isLogicalDeleted();

}
