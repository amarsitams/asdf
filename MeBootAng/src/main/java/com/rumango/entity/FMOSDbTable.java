package com.rumango.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FMOSDbTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String userName;
	private String programId;
	private String excludeList;
	private String monitorRequired;
	private String sqlStatement;
	private Date ExecDate;
	private Timestamp ExecTime;
	@Column(name = "maker_id")
	private String maker;
	@Column(name = "verifier_id")
	private String verifierId;
	@Column(name = "maker_dt_stamp")
	private Date makerDtStamp;
	@Column(name = "checker_dt_stamp")
	private Date checkerDtStamp;
	@Column(name = "record_status")
	private String recordStatus;
	@Column(name = "auth_status")
	private String authStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getExcludeList() {
		return excludeList;
	}
	public void setExcludeList(String excludeList) {
		this.excludeList = excludeList;
	}
	public String getMonitorRequired() {
		return monitorRequired;
	}
	public void setMonitorRequired(String monitorRequired) {
		this.monitorRequired = monitorRequired;
	}
	public String getSqlStatement() {
		return sqlStatement;
	}
	public void setSqlStatement(String sqlStatement) {
		this.sqlStatement = sqlStatement;
	}
	public Date getExecDate() {
		return ExecDate;
	}
	public void setExecDate(Date execDate) {
		ExecDate = execDate;
	}
	public Timestamp getExecTime() {
		return ExecTime;
	}
	public void setExecTime(Timestamp execTime) {
		ExecTime = execTime;
	}
	@Override
	public String toString() {
		return "FMOSDbTable [id=" + id + ", userName=" + userName + ", programId=" + programId + ", excludeList="
				+ excludeList + ", monitorRequired=" + monitorRequired + ", sqlStatement=" + sqlStatement
				+ ", ExecDate=" + ExecDate + ", ExecTime=" + ExecTime + "]";
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getVerifierId() {
		return verifierId;
	}
	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}
	public Date getMakerDtStamp() {
		return makerDtStamp;
	}
	public void setMakerDtStamp(Date makerDtStamp) {
		this.makerDtStamp = makerDtStamp;
	}
	public Date getCheckerDtStamp() {
		return checkerDtStamp;
	}
	public void setCheckerDtStamp(Date checkerDtStamp) {
		this.checkerDtStamp = checkerDtStamp;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
}
