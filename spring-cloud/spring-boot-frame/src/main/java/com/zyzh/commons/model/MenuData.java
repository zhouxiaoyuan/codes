package com.zyzh.commons.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "Menu", namespace = "")
public class MenuData implements Serializable{
	private String appCode;
	private String moduleId;
	private String moduleName;
	private String moduleUrl;
	private String parentId;
	private String parentIds;

	@XmlElement(name = "AppCode")
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	@XmlElement(name = "ModuleId")
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@XmlElement(name = "ModuleName")
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@XmlElement(name = "ModuleUrl")
	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	@XmlElement(name = "ParentId")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@XmlElement(name = "ParentIds")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	@Override
	public String toString() {
		return "MenuData [appCode=" + appCode + ", moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleUrl="
				+ moduleUrl + ", parentId=" + parentId + ", parentIds=" + parentIds + "]";
	}

}
