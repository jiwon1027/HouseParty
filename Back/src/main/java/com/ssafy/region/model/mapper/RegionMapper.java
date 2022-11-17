package com.ssafy.region.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.region.model.dto.AddressInfo;

@Mapper
public interface RegionMapper {
	List<AddressInfo> getSidoList() throws SQLException;
	List<AddressInfo> getGugunList(String code) throws SQLException;
	List<AddressInfo> getDongList(String code) throws SQLException;

}
