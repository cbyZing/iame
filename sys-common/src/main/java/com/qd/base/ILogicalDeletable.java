package com.qd.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

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
