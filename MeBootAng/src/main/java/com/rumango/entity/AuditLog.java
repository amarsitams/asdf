package com.rumango.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit_logs")
//@NamedQuery(name="AuditLog.findAll", query="SELECT a FROM AuditLog a")
public class AuditLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column
	private String action;

	@Column(name="creator_id")
	private String creatorId;

	@Column(name = "creator_dt_stamp")
	private Date creatorDtStamp;

	@Column(name="verifier_id")
	private String verifierId;

	@Column(name="verifier_dt_stamp")
	private Date verifierDtStamp;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="action_perform_by", nullable=false)
	private String actionPerformBy;

	
	@Column(name="loggable_id")
	private Integer loggableId;

	@Column(name="record")
	private String record;


	@Column(name="number_of_modification")
	private Integer numberOfModification;


	

	public AuditLog() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}


	public Date getCreatorDtStamp() {
		return creatorDtStamp;
	}

	public void setCreatorDtStamp(Date creatorDtStamp) {
		this.creatorDtStamp = creatorDtStamp;
	}

	public Integer getLoggableId() {
		return this.loggableId;
	}

	public void setLoggableId(Integer loggableId) {
		this.loggableId = loggableId;
	}

	
//	public String getMaintananceStatus() {
//		return this.maintananceStatus;
//	}
//
//	public void setMaintananceStatus(String maintananceStatus) {
//		this.maintananceStatus = maintananceStatus;
//	}

//	public String getModification() {
//		return this.modification;
//	}
//
//	public void setModification(String modification) {
//		this.modification = modification;
//	}

	public Integer getNumberOfModification() {
		return this.numberOfModification;
	}

	public void setNumberOfModification(Integer numberOfModification) {
		this.numberOfModification = numberOfModification;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date sqlDate) {
		this.updatedAt = sqlDate;
	}
//
//	public String getVerificationStatus() {
//		return this.verificationStatus;
//	}
//
//	public void setVerificationStatus(String verificationStatus) {
//		this.verificationStatus = verificationStatus;
//	}

	public String getVerifierId() {
		return verifierId;
	}

	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}

	public Date getVerifierDtStamp() {
		return verifierDtStamp;
	}

	public String getActionPerformBy() {
		return actionPerformBy;
	}

	public void setActionPerformBy(String actionPerformBy) {
		this.actionPerformBy = actionPerformBy;
	}

	public void setVerifierDtStamp(Date verifierDtStamp) {
		this.verifierDtStamp = verifierDtStamp;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	
	

}