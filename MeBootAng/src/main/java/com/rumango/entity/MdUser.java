//package com.rumango.entity;
//import java.util.Collection;
//import java.util.Date;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name="mduser")
//public class MdUser {
//	    @Id
//	    private String userId;
//	    private String userName;
//	    private String password;
//	    private String confirmPassword;
//	    private String email;
//	    private String mobile;
//	    private String ldapid;
//	    private String ldapname;
//	    private String userAccessOption;
//	    private Boolean emailNotif;
//	    private Boolean smsNotif;
//	    private Boolean maintAllowed;
//	    private Boolean autoAuth;
//		private String authStatus;
//		private String recordStatus;
//		@Transient
//		@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//		@JoinTable(joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="roleName"))
//		private Collection<RolesEntity1> role;
//	    
//	    @Column(nullable = false, updatable = false)
//	    @DateTimeFormat(pattern="mm-dd-yyyy")
//	    private Date createdAt;
//	    
//	    @Column(nullable = false)
//	    @DateTimeFormat(pattern="mm-dd-yyyy")
//	    private Date updatedAt;
//	    
//		public Collection<RolesEntity1> getRole() {
//			return role;
//		}
//		public void setRole(Collection<RolesEntity1> role) {
//			this.role = role;
//		}
//		public Date getCreatedAt() {
//			
//			return createdAt;
//		}
//		public void setCreatedAt(Date createdAt) {
//			this.createdAt = createdAt;
//		}
//		public Date getUpdatedAt() {
//			return updatedAt;
//		}
//		public void setUpdatedAt(Date updatedAt) {
//			this.updatedAt = updatedAt;
//		}
//		public String getUserId() {
//			return userId;
//		}
//		public void setUserId(String userId) {
//			this.userId = userId;
//		}
//		public String getUserName() {
//			return userName;
//		}
//		public void setUserName(String userName) {
//			this.userName = userName;
//		}
//		public String getPassword() {
//			return password;
//		}
//		public void setPassword(String password) {
//			this.password = password;
//		}
//		public String getConfirmPassword() {
//			return confirmPassword;
//		}
//		public void setConfirmPassword(String confirmPassword) {
//			this.confirmPassword = confirmPassword;
//		}
//		public String getEmail() {
//			return email;
//		}
//		public void setEmail(String email) {
//			this.email = email;
//		}
//		public String getMobile() {
//			return mobile;
//		}
//		public void setMobile(String mobile) {
//			this.mobile = mobile;
//		}
//		public String getLdapid() {
//			return ldapid;
//		}
//		public void setLdapid(String ldapid) {
//			this.ldapid = ldapid;
//		}
//		public String getLdapname() {
//			return ldapname;
//		}
//		public void setLdapname(String ldapname) {
//			this.ldapname = ldapname;
//		}
//		public String getUserAccessOption() {
//			return userAccessOption;
//		}
//		public void setUserAccessOption(String userAccessOption) {
//			this.userAccessOption = userAccessOption;
//		}
//		public Boolean getEmailNotif() {
//			return emailNotif;
//		}
//		public void setEmailNotif(Boolean emailNotif) {
//			this.emailNotif = emailNotif;
//		}
//		public Boolean getSmsNotif() {
//			return smsNotif;
//		}
//		public void setSmsNotif(Boolean smsNotif) {
//			this.smsNotif = smsNotif;
//		}
//		public Boolean getMaintAllowed() {
//			return maintAllowed;
//		}
//		public void setMaintAllowed(Boolean maintAllowed) {
//			this.maintAllowed = maintAllowed;
//		}
//		public Boolean getAutoAuth() {
//			return autoAuth;
//		}
//		public void setAutoAuth(Boolean autoAuth) {
//			this.autoAuth = autoAuth;
//		}
//		
//		
//		public String getAuthStatus() {
//			return authStatus;
//		}
//		public void setAuthStatus(String authStatus) {
//			this.authStatus = authStatus;
//		}
//       public String getRecordStatus() {
//			return recordStatus;
//		}
//		public void setRecordStatus(String recordStatus) {
//			this.recordStatus = recordStatus;
//		}
//		//		public MdUser(String userId, String userName, String password, String confirmPassword, String email,
////				String mobile, String ldapid, String ldapname, String userAccessOption, Boolean emailNotif,
////				Boolean smsNotif, Boolean maintAllowed, Boolean autoAuth, Date createdAt, Date updatedAt, String authStatus) {
////			// super();
////			this.userId = userId;
////			this.userName = userName;
////			this.password = password;
////			this.confirmPassword = confirmPassword;
////			this.email = email;
////			this.mobile = mobile;
////			this.ldapid = ldapid;
////			this.ldapname = ldapname;
////			this.userAccessOption = userAccessOption;
////			this.emailNotif = emailNotif;
////			this.smsNotif = smsNotif;
////			this.maintAllowed = maintAllowed;
////			this.autoAuth = autoAuth;
////			this.createdAt = createdAt;
////			this.updatedAt = updatedAt;
////			 this.authStatus = authStatus;
////		}
//		public MdUser() {
//			//super();
//			// TODO Auto-generated constructor stub
//		}
//		
//		
//		
//		
//}
