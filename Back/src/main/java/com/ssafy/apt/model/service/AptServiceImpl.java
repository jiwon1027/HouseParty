package com.ssafy.apt.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.apt.model.dto.AptInfo;
import com.ssafy.apt.model.dto.Area;
import com.ssafy.apt.model.mapper.AptMapper;

@Service
public class AptServiceImpl implements AptService {

	private AptMapper aptMapper;
	
	@Autowired
	public AptServiceImpl(AptMapper aptMapper) {
		super();
		this.aptMapper = aptMapper;
	}

//	@Override
//	public List<AptInfo> aptList(int dealyear, int dealmonth, String dongCode) throws SQLException {
//		return aptMapper.aptList(dealyear, dealmonth, dongCode);
//
//	}
	
	@Override
	public List<AptInfo> aptList(String dongCode) throws SQLException {
		return aptMapper.aptList(dongCode);

	}
	@Override
	public void insertFavArea(Map<String,String> map) throws SQLException {
		aptMapper.insertFavArea(map);
	}

	@Override
	public void deleteFavArea(String userId, String dongcode) throws SQLException {
		aptMapper.deleteFavArea(userId, dongcode);
	}

	@Override
	public void insertFavApt(Map<String,String> map) throws SQLException {
		aptMapper.insertFavApt(map);
	}

	@Override
	public void deleteFavApt(Map<String,String> map) throws SQLException {
		aptMapper.deleteFavApt(map);
	}

	@Override
	public List<AptInfo> searchByAptName(String aptName) throws SQLException {
		return aptMapper.searchByAptName(aptName);
	}

	@Override
	public List<String> getInterestArea(String id) throws SQLException {
	    return aptMapper.getInterestArea(id);
	}

	@Override
	public Area getInterestAreaName(String dongCode) throws SQLException {
	    return aptMapper.getInterestAreaName(dongCode);
	}

	@Override
	public List<AptInfo> favAptCodeList(String userId) throws SQLException {
		return aptMapper.favAptCodeList(userId);
	}

	@Override
	public List<AptInfo> favAptList(String aptCode) throws SQLException {
		return aptMapper.favAptList(aptCode);
	}



}
