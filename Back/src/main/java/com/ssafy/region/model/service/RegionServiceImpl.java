package com.ssafy.region.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.region.model.dto.AddressInfo;
import com.ssafy.region.model.mapper.RegionMapper;

@Service
public class RegionServiceImpl implements RegionService {

	private RegionMapper regionMapper;
	
	@Autowired
	public RegionServiceImpl(RegionMapper regionMapper) {
		super();
		this.regionMapper = regionMapper;
	}

	@Override
	public List<AddressInfo> getSidoList() throws SQLException {
		return regionMapper.getSidoList();
	}

	@Override
	public List<AddressInfo> getGugunList(String code) throws SQLException {
		return regionMapper.getGugunList(code);
	}

	@Override
	public List<AddressInfo> getDongList(String code) throws SQLException {
		return regionMapper.getDongList(code);
	}

}
