package com.ssafy.apt.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.apt.model.dto.AptInfo;

@Mapper
public interface AptMapper {
	List<AptInfo> aptList(int dealyear, int dealmonth, String dongCode) throws SQLException;
	void insertFavArea(Map<String,String> map) throws SQLException;
	void deleteFavArea(Map<String,String> map) throws SQLException;
	void insertFavApt(Map<String,String> map) throws SQLException;
	void deleteFavApt(Map<String,String> map) throws SQLException;
	
}
