package com.ssafy.region.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.region.model.dto.AddressInfo;

public interface RegionService {
	List<AddressInfo> getSidoList() throws SQLException;
	List<AddressInfo> getGugunList(String code) throws SQLException;
	List<AddressInfo> getDongList(String code) throws SQLException;
}
