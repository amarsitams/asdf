package com.rumango.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column
	private String applications;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_id")
	private String userId;

	@Column(name = "change_password")
	private Boolean changePassword;

//	@Column(name = "created_at", nullable = false)
//	private Date createdAt;

	@Column(name = "creator_dt_stamp")
	private Date creatorDtStamp;

	@Column(name = "creator_id")
	private String creatorId;

	@Column(name = "current_sign_in_at")
	private Timestamp currentSignInAt;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(nullable = false)
	private String email;

	@Column(name = "email_notification")
	private Boolean emailNotification;

	@Column(name = "encrypted_password", nullable = false)
	private String encryptedPassword;

	@Column(name = "failed_attempts", nullable = true)
	private Integer failedAttempts;

//	@Column(name="last_sign_in_at")
//	private Timestamp lastSignInAt;

//	@Column(name="last_sign_in_ip")
//	private String lastSignInIp;

	@Column(name = "ldap_user_id", length = 35)
	private String ldapUserId;

	@Column(name = "locked_at")
	private Timestamp lockedAt;

	@Column(length = 35)
	private String mobile;

	@Column(name = "msad_user_id", length = 35)
	private String msadUserId;

//	@Column(name = "notification_emails")
//	private String notificationEmails;

//	@Column(name = "notification_mobiles")
//	private String notificationMobiles;

	@Column(name = "record_status", length = 35)
	private String recordStatus;

//	@Column(name = "remember_created_at")
//	private Timestamp rememberCreatedAt;

//	@Column(name = "reset_password_sent_at")
//	private Timestamp resetPasswordSentAt;

//	@Column(name = "reset_password_token")
//	private String resetPasswordToken;

	@Column(name = "sign_in_count", nullable = true)
	private Integer signInCount;

	@Column(name = "sms_notification")
	private Boolean smsNotification;

//	@Column(name = "unlock_token")
//	private String unlockToken;

	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "user_name", length = 35)
	private String userName;

//	private Boolean verified;

	@Column(name = "verifier_dt_stamp")
	private java.sql.Date verifierDtStamp;

	@Column(name = "verifier_id")
	private String verifierId;

	@Column(name = "auth_status")
	private String authStatus;

	@Column(name = "user_role")
	private String[] roleForUser;

	@Column(name = "version_no")
	private int versionNo;

	@Column(name = "logout_time")
	private Timestamp logoutTime;

	private String fristTimeAuth;

	public Timestamp getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String[] getRoleForUser() {
		return roleForUser;
	}

	public void setRoleForUser(String[] roleForUser) {
		this.roleForUser = roleForUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplications() {
		return applications;
	}

	public void setApplications(String applications) {
		this.applications = applications;
	}

	public Boolean getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Boolean changePassword) {
		this.changePassword = changePassword;
	}

//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Timestamp getCurrentSignInAt() {
		return currentSignInAt;
	}

	public void setCurrentSignInAt(Timestamp currentSignInAt) {
		this.currentSignInAt = currentSignInAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(Boolean emailNotification) {
		this.emailNotification = emailNotification;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public Integer getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(Integer failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public String getLdapUserId() {
		return ldapUserId;
	}

	public void setLdapUserId(String ldapUserId) {
		this.ldapUserId = ldapUserId;
	}

	public Timestamp getLockedAt() {
		return lockedAt;
	}

	public void setLockedAt(Timestamp lockedAt) {
		this.lockedAt = lockedAt;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMsadUserId() {
		return msadUserId;
	}

	public void setMsadUserId(String msadUserId) {
		this.msadUserId = msadUserId;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Integer getSignInCount() {
		return signInCount;
	}

	public void setSignInCount(Integer signInCount) {
		this.signInCount = signInCount;
	}

	public Boolean getSmsNotification() {
		return smsNotification;
	}

	public void setSmsNotification(Boolean smsNotification) {
		this.smsNotification = smsNotification;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.sql.Date getVerifierDtStamp() {
		return verifierDtStamp;
	}

	public void setVerifierDtStamp(java.sql.Date sqlDate) {
		this.verifierDtStamp = sqlDate;
	}

	public String getVerifierId() {
		return verifierId;
	}

	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getCreatorDtStamp() {
		return creatorDtStamp;
	}

	public void setCreatorDtStamp(Date creatorDtStamp) {
		this.creatorDtStamp = creatorDtStamp;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", applications=" + applications + ", userId=" + userId + ", changePassword="
				+ changePassword + ", creatorDtStamp=" + creatorDtStamp + ", creatorId=" + creatorId
				+ ", currentSignInAt=" + currentSignInAt + ", updatedBy=" + updatedBy + ", email=" + email
				+ ", emailNotification=" + emailNotification + ", encryptedPassword=" + encryptedPassword
				+ ", failedAttempts=" + failedAttempts + ", ldapUserId=" + ldapUserId + ", lockedAt=" + lockedAt
				+ ", mobile=" + mobile + ", msadUserId=" + msadUserId + ", recordStatus=" + recordStatus
				+ ", signInCount=" + signInCount + ", smsNotification=" + smsNotification + ", updatedAt=" + updatedAt
				+ ", userName=" + userName + ", verifierDtStamp=" + verifierDtStamp + ", verifierId=" + verifierId
				+ ", authStatus=" + authStatus + ", roleForUser=" + Arrays.toString(roleForUser) + ", versionNo="
				+ versionNo + ", logoutTime=" + logoutTime + "]";
	}

	public String getFristTimeAuth() {
		return fristTimeAuth;
	}

	public void setFristTimeAuth(String fristTimeAuth) {
		this.fristTimeAuth = fristTimeAuth;
	}

}