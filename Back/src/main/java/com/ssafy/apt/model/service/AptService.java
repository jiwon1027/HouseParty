package com.ssafy.apt.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.apt.model.dto.AptInfo;
import com.ssafy.apt.model.dto.Area;

public interface AptService {
//	List<AptInfo> aptList(int dealyear, int dealmonth, String dongCode) throws SQLException;
	List<AptInfo> aptList(String dongCode) throws SQLException;
	List<AptInfo> searchByAptName(String aptName) throws SQLException;

	void insertFavArea(Map<String,String> map) throws SQLException;
	void deleteFavArea(String userId, String dongcode) throws SQLException;
	void insertFavApt(Map<String,String> map) throws SQLException;
	void deleteFavApt(Map<String,String> map) throws SQLException;
	
	List<String> getInterestArea(String id) throws SQLException;
    Area getInterestAreaName(String dongCode) throws SQLException;
    
	List<AptInfo> favAptCodeList(String userId) throws SQLException;
	List<AptInfo> favAptList(String aptCode) throws SQLException;


}
