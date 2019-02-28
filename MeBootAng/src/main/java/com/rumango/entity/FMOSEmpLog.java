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
public class FMOSEmpLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String applicationUserId;
	private String creatorId;
	private String empId;
	private String empName;
	private String email;
	private Timestamp loginTime;
	private Timestamp logoutTime;
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
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public Timestamp getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
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
	public String getApplicationUserId() {
		return applicationUserId;
	}
	public void setApplicationUserId(String applicationUserId) {
		this.applicationUserId = applicationUserId;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
}
