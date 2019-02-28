package com.rumango.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table
@Entity
public class FMOSDsMaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String appName;
	private String tableName;
	private String databaseStatement;
	private String action;
	private String allowTransaction;
	private String maker;
	private String checker;
	private String verifier;
	private Date makerCheckStamp;
	private Date checkerDtStamp;
	private Date verifierDtStamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDatabaseStatement() {
		return databaseStatement;
	}
	public void setDatabaseStatement(String databaseStatement) {
		this.databaseStatement = databaseStatement;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAllowTransaction() {
		return allowTransaction;
	}
	public void setAllowTransaction(String allowTransaction) {
		this.allowTransaction = allowTransaction;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getVerifier() {
		return verifier;
	}
	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}
	public Date getMakerCheckStamp() {
		return makerCheckStamp;
	}
	public void setMakerCheckStamp(Date makerCheckStamp) {
		this.makerCheckStamp = makerCheckStamp;
	}
	public Date getCheckerDtStamp() {
		return checkerDtStamp;
	}
	public void setCheckerDtStamp(Date checkerDtStamp) {
		this.checkerDtStamp = checkerDtStamp;
	}
	public Date getVerifierDtStamp() {
		return verifierDtStamp;
	}
	public void setVerifierDtStamp(Date verifierDtStamp) {
		this.verifierDtStamp = verifierDtStamp;
	}
}
