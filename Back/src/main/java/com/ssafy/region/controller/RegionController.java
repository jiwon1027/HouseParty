package com.ssafy.region.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.region.model.dto.AddressInfo;
import com.ssafy.region.model.service.RegionService;

@RestController
@RequestMapping("/region")
@CrossOrigin("*")
public class RegionController {
	private RegionService regionService;

	@Autowired
	public RegionController(RegionService regionService) {
		System.out.println("RegionController 생성자 호출");
		this.regionService = regionService;
	}
	
	@GetMapping("/sido")
	public ResponseEntity<?> getSidoList() {
		List<AddressInfo> addressInfo;
		try {
			addressInfo = regionService.getSidoList();
			return new ResponseEntity<List<AddressInfo>>(addressInfo, HttpStatus.OK);

		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/gugun/{regCode}")
	public ResponseEntity<?> getGugunList(@PathVariable String regCode) {
		List<AddressInfo> addressInfo;
		try {
			String str = regCode.substring(0,2);
			
			addressInfo = regionService.getGugunList(str);
			return new ResponseEntity<List<AddressInfo>>(addressInfo, HttpStatus.OK);

		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}


		
		
	}
	
	@GetMapping("/dong/{dongCode}")
	public ResponseEntity<?> getDongList(@PathVariable String dongCode) {
		List<AddressInfo> addressInfo;
		try {
			String str = dongCode.substring(0,4);

			addressInfo = regionService.getDongList(str);
			return new ResponseEntity<List<AddressInfo>>(addressInfo, HttpStatus.OK);

		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}


	}

	
	
}
