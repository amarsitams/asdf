package com.rumango.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class TagMapping {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String extSysCode1;
	private String extSysCode2;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExtSysCode1() {
		return extSysCode1;
	}
	public void setExtSysCode1(String extSysCode1) {
		this.extSysCode1 = extSysCode1;
	}
	public String getExtSysCode2() {
		return extSysCode2;
	}
	public void setExtSysCode2(String extSysCode2) {
		this.extSysCode2 = extSysCode2;
	}
}
