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
public class FMOSCustTxnLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String creatorId;
	private String customerId;
	private String customerAccount;
	private String customerName;
	private String monitorRequired;
	private String channel;
	private String txnAmt;
	private int repeatedTxn;
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getTxnAmt() {
		return txnAmt;
	}
	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}
	public int getRepeatedTxn() {
		return repeatedTxn;
	}
	public void setRepeatedTxn(int repeatedTxn) {
		this.repeatedTxn = repeatedTxn;
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
		return "FMOSCustTxnLog [id=" + id + ", customerId=" + customerId + ", customerAccount=" + customerAccount
				+ ", channel=" + channel + ", txnAmt=" + txnAmt + ", repeatedTxn=" + repeatedTxn + ", ExecDate="
				+ ExecDate + ", ExecTime=" + ExecTime + "]";
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMonitorRequired() {
		return monitorRequired;
	}
	public void setMonitorRequired(String monitorRequired) {
		this.monitorRequired = monitorRequired;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
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
