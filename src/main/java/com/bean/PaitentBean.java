package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PaitentBean {

	private int pId;
	private String pName;
	private int pAge;
	private int dId;
	private String dName;
	private String dEmail;
	private int dAge;
	private int dExp;

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public int getdAge() {
		return dAge;
	}

	public void setdAge(int dAge) {
		this.dAge = dAge;
	}

	public int getdExp() {
		return dExp;
	}

	public void setdExp(int dExp) {
		this.dExp = dExp;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpAge() {
		return pAge;
	}

	public void setpAge(int pAge) {
		this.pAge = pAge;
	}

}
