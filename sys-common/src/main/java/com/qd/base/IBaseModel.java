package com.qd.base;

import java.io.Serializable;

public interface IBaseModel<ID extends Serializable> extends Serializable {
	/**
	 * 获取当前对象ID属性值
	 * @return
	 */
	ID getId();
	/**
	 * 设置ID属性
	 * @param id
	 */
	void setId(ID id);
}
