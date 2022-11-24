package com.ssafy.apt.model.dto;

public class Area {
    private String sidoName;
    private String gugunName;
    private String dongName;
    private String dongCode;
    

    public Area() {}


	public Area(String sidoName, String gugunName, String dongName, String dongCode) {
		super();
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.dongCode = dongCode;
	}


	public String getSidoName() {
		return sidoName;
	}


	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}


	public String getGugunName() {
		return gugunName;
	}


	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}


	public String getDongName() {
		return dongName;
	}


	public void setDongName(String dongName) {
		this.dongName = dongName;
	}


	public String getDongCode() {
		return dongCode;
	}


	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

    
}