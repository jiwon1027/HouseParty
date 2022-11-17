package com.ssafy.apt.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.apt.model.dto.AptInfo;
import com.ssafy.apt.model.mapper.AptMapper;

@Service
public class AptServiceImpl implements AptService {

	private AptMapper aptMapper;
	
	@Autowired
	public AptServiceImpl(AptMapper aptMapper) {
		super();
		this.aptMapper = aptMapper;
	}

	@Override
	public List<AptInfo> aptList(int dealyear, int dealmonth, String dongCode) throws SQLException {
		return aptMapper.aptList(dealyear, dealmonth, dongCode);

	}

	@Override
	public void insertFavArea(Map<String,String> map) throws SQLException {
		aptMapper.insertFavArea(map);
	}

	@Override
	public void deleteFavArea(Map<String,String> map) throws SQLException {
		aptMapper.deleteFavArea(map);
	}

	@Override
	public void insertFavApt(Map<String,String> map) throws SQLException {
		aptMapper.insertFavApt(map);
	}

	@Override
	public void deleteFavApt(Map<String,String> map) throws SQLException {
		aptMapper.deleteFavApt(map);
	}



}
