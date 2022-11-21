package com.ssafy.apt.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.apt.model.dto.AptInfo;
import com.ssafy.apt.model.service.AptService;

@RestController
@RequestMapping("/apts")
@CrossOrigin("*")
public class AptRestController {
	
	private AptService aptService;

	@Autowired
	public AptRestController(AptService aptService) {
		super();

		this.aptService = aptService;
	}
	
	@GetMapping("/{dongcode}")
	public ResponseEntity<?> aptList(@PathVariable("dongcode") String dongcode) {
		List<AptInfo> list;
		
		try {
//			list = aptService.aptList(aptInfo.getDealyear(), aptInfo.getDealmonth(), aptInfo.getDongcode());
			
			list = aptService.aptList(dongcode);
			return new ResponseEntity<List<AptInfo>>(list, HttpStatus.OK);

		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<?> searchByAptName(@RequestBody AptInfo aptInfo) {
		System.out.println(211111);
		System.out.println(aptInfo.toString());
		
		
		List<AptInfo> list;
		
		try {
			System.out.println(aptInfo.getApartmentName());
			list = aptService.searchByAptName(aptInfo.getApartmentName());
			System.out.println("sql 실행 완료");
			return new ResponseEntity<List<AptInfo>>(list, HttpStatus.OK);

		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/fav-area")
	public ResponseEntity<?> insertFavArea(@RequestBody Map<String, String> map) {
		
		try {
			aptService.insertFavArea(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/fav-area")
	public ResponseEntity<?> deleteFavArea(@RequestBody Map<String, String> map) {
	
		try {
			aptService.deleteFavArea(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@PostMapping("/fav-apt")
	public ResponseEntity<?> insertFavApt(@RequestBody Map<String, String> map) {
		
		try {
			aptService.insertFavApt(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/fav-apt")
	public ResponseEntity<?> deleteFavApt(@RequestBody Map<String, String> map) {
		
		
		try {
			aptService.deleteFavApt(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
}
