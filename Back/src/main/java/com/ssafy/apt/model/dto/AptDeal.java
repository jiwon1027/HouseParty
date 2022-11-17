package com.ssafy.apt.model.dto;

import lombok.Data;

@Data
public class AptDeal {
	private long no;
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private String area;
	private String floor;
	private String cancelDealType;
	private long aptCode;

}
