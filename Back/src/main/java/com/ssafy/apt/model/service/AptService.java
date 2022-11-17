package com.ssafy.apt.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.apt.model.dto.AptInfo;

public interface AptService {
	List<AptInfo> aptList(int dealyear, int dealmonth, String dongCode) throws SQLException;
	void insertFavArea(Map<String,String> map) throws SQLException;
	void deleteFavArea(Map<String,String> map) throws SQLException;
	void insertFavApt(Map<String,String> map) throws SQLException;
	void deleteFavApt(Map<String,String> map) throws SQLException;
}
