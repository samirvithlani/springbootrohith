package com.bean;

import org.springframework.stereotype.Component;

@Component
public class DoctorBean {

	private int dId;
	private String dName;
	private int dExp;
	private int dAge;
	private String dEmail;

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getdExp() {
		return dExp;
	}

	public void setdExp(int dExp) {
		this.dExp = dExp;
	}

	public int getdAge() {
		return dAge;
	}

	public void setdAge(int dAge) {
		this.dAge = dAge;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

}
