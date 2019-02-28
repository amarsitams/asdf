package com.rumango.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class TagMappingClass {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	private String sourceSystem;
	private String targetSystem;
	private String mandatoryField;
	private String listOfValues;
	private String byQuery;
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	
	
	public String getTargetSystem() {
		return targetSystem;
	}
	public void setTargetSystem(String targetSystem) {
		this.targetSystem = targetSystem;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMandatoryField() {
		return mandatoryField;
	}
	public void setMandatoryField(String mandatoryField) {
		this.mandatoryField = mandatoryField;
	}
	public String getListOfValues() {
		return listOfValues;
	}
	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}
	public String getByQuery() {
		return byQuery;
	}
	public void setByQuery(String byQuery) {
		this.byQuery = byQuery;
	}
}
