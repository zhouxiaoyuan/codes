package com.zyzh.commons.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "MenuInfo", namespace = "")
public class MenuInfo {

	private List<MenuData> menuData;

	public List<MenuData> getMenu() {
		return menuData;
	}

	@XmlElement(name = "Menu")
	public void setMenu(List<MenuData> menuData) {
		this.menuData = menuData;
	}

}
