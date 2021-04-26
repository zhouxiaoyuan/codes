package com.zyzh.commons.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "UserInfo", namespace = "")
public class UserInfo implements Serializable {

	private String adminFlag;
	private String appCode;
	private String orgCode;
	private String orgName;
	private String orgType;
	private String purview;
	private String userLoginName;
	private String userLoginPwd;
	private String userName;
	private String userType;
	private String userId;

	@XmlElement(name = "AdminFlag")
	public String getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	@XmlElement(name = "AppCode")
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	@XmlElement(name = "OrgCode")
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@XmlElement(name = "OrgName")
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@XmlElement(name = "OrgType")
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	@XmlElement(name = "Purview")
	public String getPurview() {
		return purview;
	}

	public void setPurview(String purview) {
		this.purview = purview;
	}

	@XmlElement(name = "UserLoginName")
	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	@XmlElement(name = "UserLoginPwd")
	public String getUserLoginPwd() {
		return userLoginPwd;
	}

	public void setUserLoginPwd(String userLoginPwd) {
		this.userLoginPwd = userLoginPwd;
	}

	@XmlElement(name = "UserName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement(name = "UserType")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@XmlElement(name = "UserId")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
