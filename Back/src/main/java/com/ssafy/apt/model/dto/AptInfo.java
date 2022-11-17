package com.ssafy.apt.model.dto;

import lombok.Data;


public class AptInfo {
	private long aptCode;
	private String dongcode;
	private String apartmentName;
	private String dealAmount;
	private String area;
	private int dealyear;
	private int dealmonth;
	private int dealday;
	private String lat;
	private String lng;
	
	
	public AptInfo() {
		super();
	}


	public AptInfo(long aptCode, String dongcode, String apartmentName, String dealAmount, String area, int dealyear,
			int dealmonth, int dealday, String lat, String lng) {
		super();
		this.aptCode = aptCode;
		this.dongcode = dongcode;
		this.apartmentName = apartmentName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.dealyear = dealyear;
		this.dealmonth = dealmonth;
		this.dealday = dealday;
		this.lat = lat;
		this.lng = lng;
	}

	
	
	public AptInfo(int dealyear, int dealmonth, String dongcode) {
		super();
		this.dongcode = dongcode;
		this.dealyear = dealyear;
		this.dealmonth = dealmonth;
	}



	public long getAptCode() {
		return aptCode;
	}

	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getDealyear() {
		return dealyear;
	}

	public void setDealyear(int dealyear) {
		this.dealyear = dealyear;
	}

	public int getDealmonth() {
		return dealmonth;
	}

	public void setDealmonth(int dealmonth) {
		this.dealmonth = dealmonth;
	}

	public int getDealday() {
		return dealday;
	}

	public void setDealday(int dealday) {
		this.dealday = dealday;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
	
	
	

	

}
