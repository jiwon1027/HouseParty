package com.ssafy.region.model.dto;

import lombok.Getter;
import lombok.Setter;

public class AddressInfo {
	private String dongCode;
	private String name;
	public AddressInfo(String dongCode, String name) {
		super();
		this.dongCode = dongCode;
		this.name = name;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		


	
	
	

	
	
	
}
