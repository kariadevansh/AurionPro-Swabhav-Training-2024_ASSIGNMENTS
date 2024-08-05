package com.apro.model;

public class Country {
	private String countryCode;
	private String countryName;
	private int countryId;
	public Country(String countryCode, String countryName, int countryId) {
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.countryId = countryId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}	
}
