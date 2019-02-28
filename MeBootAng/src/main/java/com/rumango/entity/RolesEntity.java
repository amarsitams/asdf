package com.rumango.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RolesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
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
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_desc")
	private String roleDesc;
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "updated_at")
	private Date updatedAt;

	private String new1;
	private String copy1;
	private String delete1;
	private String close1;
	private String reopen1;
	private String unlock1;
	private String print1;
	private String auth1;
	private String view1;
	private String new2;
	private String copy2;
	private String delete2;
	private String close2;
	private String reopen2;
	private String unlock2;
	private String print2;
	private String auth2;
	private String view2;
	private String new3;
	private String copy3;
	private String delete3;
	private String close3;
	private String reopen3;
	private String unlock3;
	private String print3;
	private String auth3;
	private String view3;
	private String new4;
	private String copy4;
	private String delete4;
	private String close4;
	private String reopen4;
	private String unlock4;
	private String print4;
	private String auth4;
	private String view4;
	
	@Column(name="version_no")
	private int versionNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getNew1() {
		return new1;
	}

	public void setNew1(String new1) {
		this.new1 = new1;
	}

	public String getCopy1() {
		return copy1;
	}

	public void setCopy1(String copy1) {
		this.copy1 = copy1;
	}

	public String getDelete1() {
		return delete1;
	}

	public void setDelete1(String delete1) {
		this.delete1 = delete1;
	}

	public String getClose1() {
		return close1;
	}

	public void setClose1(String close1) {
		this.close1 = close1;
	}

	

	public String getUnlock1() {
		return unlock1;
	}

	public void setUnlock1(String unlock1) {
		this.unlock1 = unlock1;
	}

	public String getPrint1() {
		return print1;
	}

	public void setPrint1(String print1) {
		this.print1 = print1;
	}

	public String getAuth1() {
		return auth1;
	}

	public void setAuth1(String auth1) {
		this.auth1 = auth1;
	}

	public String getView1() {
		return view1;
	}

	public void setView1(String view1) {
		this.view1 = view1;
	}

	public String getNew2() {
		return new2;
	}

	public void setNew2(String new2) {
		this.new2 = new2;
	}

	public String getCopy2() {
		return copy2;
	}

	public void setCopy2(String copy2) {
		this.copy2 = copy2;
	}

	public String getDelete2() {
		return delete2;
	}

	public void setDelete2(String delete2) {
		this.delete2 = delete2;
	}

	public String getClose2() {
		return close2;
	}

	public void setClose2(String close2) {
		this.close2 = close2;
	}

	
	public String getUnlock2() {
		return unlock2;
	}

	public void setUnlock2(String unlock2) {
		this.unlock2 = unlock2;
	}

	public String getPrint2() {
		return print2;
	}

	public void setPrint2(String print2) {
		this.print2 = print2;
	}

	public String getAuth2() {
		return auth2;
	}

	public void setAuth2(String auth2) {
		this.auth2 = auth2;
	}

	public String getView2() {
		return view2;
	}

	public void setView2(String view2) {
		this.view2 = view2;
	}

	public String getNew3() {
		return new3;
	}

	public void setNew3(String new3) {
		this.new3 = new3;
	}

	public String getCopy3() {
		return copy3;
	}

	public void setCopy3(String copy3) {
		this.copy3 = copy3;
	}

	public String getDelete3() {
		return delete3;
	}

	public void setDelete3(String delete3) {
		this.delete3 = delete3;
	}

	public String getClose3() {
		return close3;
	}

	public void setClose3(String close3) {
		this.close3 = close3;
	}

	

	public String getUnlock3() {
		return unlock3;
	}

	public void setUnlock3(String unlock3) {
		this.unlock3 = unlock3;
	}

	public String getPrint3() {
		return print3;
	}

	public void setPrint3(String print3) {
		this.print3 = print3;
	}

	public String getAuth3() {
		return auth3;
	}

	public void setAuth3(String auth3) {
		this.auth3 = auth3;
	}

	public String getView3() {
		return view3;
	}

	public void setView3(String view3) {
		this.view3 = view3;
	}

	public String getNew4() {
		return new4;
	}

	public void setNew4(String new4) {
		this.new4 = new4;
	}

	public String getCopy4() {
		return copy4;
	}

	public void setCopy4(String copy4) {
		this.copy4 = copy4;
	}

	public String getDelete4() {
		return delete4;
	}

	public void setDelete4(String delete4) {
		this.delete4 = delete4;
	}

	public String getClose4() {
		return close4;
	}

	public void setClose4(String close4) {
		this.close4 = close4;
	}

	
	public String getUnlock4() {
		return unlock4;
	}

	public void setUnlock4(String unlock4) {
		this.unlock4 = unlock4;
	}

	public String getPrint4() {
		return print4;
	}

	public void setPrint4(String print4) {
		this.print4 = print4;
	}

	public String getAuth4() {
		return auth4;
	}

	public void setAuth4(String auth4) {
		this.auth4 = auth4;
	}

	public String getView4() {
		return view4;
	}

	public void setView4(String view4) {
		this.view4 = view4;
	}

	public String getReopen1() {
		return reopen1;
	}

	public void setReopen1(String reopen1) {
		this.reopen1 = reopen1;
	}

	public String getReopen2() {
		return reopen2;
	}

	public void setReopen2(String reopen2) {
		this.reopen2 = reopen2;
	}

	public String getReopen3() {
		return reopen3;
	}

	public void setReopen3(String reopen3) {
		this.reopen3 = reopen3;
	}

	public String getReopen4() {
		return reopen4;
	}

	public void setReopen4(String reopen4) {
		this.reopen4 = reopen4;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public RolesEntity() {
		//super();
		// TODO Auto-generated constructor stub
	}

	
}
