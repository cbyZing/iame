package com.qd.base;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class BaseModel implements IBaseModel<String> {

	private static final long serialVersionUID = 7413513566622525913L;

	@Id
	@GenericGenerator(name="IDGenerator", strategy="uuid")
	@GeneratedValue(generator="IDGenerator")
	@Column(name="ID", length=32, updatable=false, unique=true, nullable=false)

	private String id;


	@Override
	public String getId() {
		return this.id;
	}


	@Override
	public void setId(String id) {
		this.id = id;
	}
	
}
