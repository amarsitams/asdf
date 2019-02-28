package com.rumango.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the tags database table.
 * 
 */
@Entity
@Table(name="tags")
//@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag {
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;


	@Column(name="created_dt_stamp")
	private Date createdDtStamp;

	@Column(name="creator_id")
	private String creatorId;

	@Column(name="err_queue_name_to_pick")
	private String errQueueNameToPick;

	@Column(name="err_queue_name_to_send")
	private String errQueueNameToSend;

	@Column(name="external_system_id")
	private String externalSystemId;

	@Column(name="latest_amend_no")
	private Integer latestAmendNo;

	@Column(name="req_queue_name_to_pick")
	private String reqQueueNameToPick;

	@Column(name="req_queue_name_to_send")
	private String reqQueueNameToSend;

	@Column(name="resp_queue_name_to_pick")
	private String respQueueNameToPick;

	@Column(name="resp_queue_name_to_send")
	private String respQueueNameToSend;

	@Column
	private String tag;

	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="auth_status")
	private String authStatus;

	@Column(name="record_status")
	private String recordStatus;
	
	@Column(name="verifier_dt_stamp")
	private Date verifierDtStamp;

	@Column(name="verifier_id")
	private String verifierId;
	
	@Column(name="version_no")
	private int versionNo;
	
	//@JsonIgnoreProperties(ignoreUnknown = true)
	//@Transient
    private String nodeForTag;
	//@Transient
	//@OneToMany(cascade=CascadeType.ALL, mappedBy = "tagId",fetch=FetchType.EAGER)
	//private List<Node> collection;
	


	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public Tag() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDtStamp() {
		return this.createdDtStamp;
	}

	public void setCreatedDtStamp(Date createdDtStamp) {
		this.createdDtStamp = createdDtStamp;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getErrQueueNameToPick() {
		return this.errQueueNameToPick;
	}

	public void setErrQueueNameToPick(String errQueueNameToPick) {
		this.errQueueNameToPick = errQueueNameToPick;
	}

	public String getErrQueueNameToSend() {
		return this.errQueueNameToSend;
	}

	public void setErrQueueNameToSend(String errQueueNameToSend) {
		this.errQueueNameToSend = errQueueNameToSend;
	}

	public String getExternalSystemId() {
		return this.externalSystemId;
	}

	public void setExternalSystemId(String externalSystemId) {
		this.externalSystemId = externalSystemId;
	}

	public Integer getLatestAmendNo() {
		return this.latestAmendNo;
	}

	public void setLatestAmendNo(Integer latestAmendNo) {
		this.latestAmendNo = latestAmendNo;
	}

	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getReqQueueNameToPick() {
		return this.reqQueueNameToPick;
	}

	public void setReqQueueNameToPick(String reqQueueNameToPick) {
		this.reqQueueNameToPick = reqQueueNameToPick;
	}

	public String getReqQueueNameToSend() {
		return this.reqQueueNameToSend;
	}

	public void setReqQueueNameToSend(String reqQueueNameToSend) {
		this.reqQueueNameToSend = reqQueueNameToSend;
	}

	public String getRespQueueNameToPick() {
		return this.respQueueNameToPick;
	}

	public void setRespQueueNameToPick(String respQueueNameToPick) {
		this.respQueueNameToPick = respQueueNameToPick;
	}

	public String getRespQueueNameToSend() {
		return this.respQueueNameToSend;
	}

	public void setRespQueueNameToSend(String respQueueNameToSend) {
		this.respQueueNameToSend = respQueueNameToSend;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date sqlDate) {
		this.updatedAt = sqlDate;
	}

	

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public Date getVerifierDtStamp() {
		return verifierDtStamp;
	}

	public void setVerifierDtStamp(Date verifierDtStamp) {
		this.verifierDtStamp = verifierDtStamp;
	}

	public String getVerifierId() {
		return this.verifierId;
	}

	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}
	//@JsonIgnoreProperties(ignoreUnknown = true)
	public String getNodeForTag() {
		return nodeForTag;
	}
	//@JsonIgnoreProperties(ignoreUnknown = true)
	public void setNodeForTag(String nodeForTag) {
		this.nodeForTag = nodeForTag;
	}



}