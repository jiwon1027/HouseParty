package com.ssafy.apt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.ssafy.apt.model.dto.Area;
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
	
	@DeleteMapping("/fav-area/{userId}/{dongcode}")
	public ResponseEntity<?> deleteFavArea(@PathVariable("userId") String userId, @PathVariable("dongcode") String dongcode) {
	
		try {
			System.out.println("delete 실행");
			aptService.deleteFavArea(userId, dongcode);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/fav-apt")
	public ResponseEntity<?> insertFavApt(@RequestBody Map<String, String> map) {
		
		try {
			System.out.println(map);
			aptService.insertFavApt(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/fav-apt/{userId}/{aptCode}/{dealAmount}/{dealyear}/{dealmonth}/{dealday}/{area}")
	public ResponseEntity<?> deleteFavApt(@PathVariable("userId") String userId, @PathVariable("aptCode") String aptCode,
			@PathVariable("dealAmount") String dealAmount, @PathVariable("dealyear") String dealyear,
			@PathVariable("dealmonth") String dealmonth, @PathVariable("dealday") String dealday, @PathVariable("area") String area) {
		
		try {
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("userId", userId);
			map.put("aptCode", aptCode);
			map.put("dealAmount", dealAmount);
			map.put("dealyear", dealyear);
			map.put("dealmonth", dealmonth);
			map.put("dealday", dealday);
			map.put("area", area);

			aptService.deleteFavApt(map);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@GetMapping("/fav-area/{id}")
    public ResponseEntity<?> getInterestArea(@PathVariable String id) {
        List<String> interestAreas;
        List<Area> areas = new ArrayList<>();
        Area area;
        try {
        	
            interestAreas = aptService.getInterestArea(id);
            
            for (int i = 0; i < interestAreas.size(); i++) {
                area = aptService.getInterestAreaName(interestAreas.get(i));
                area.setDongCode(interestAreas.get(i));
                areas.add(area);
            }
            return new ResponseEntity<List<Area>>(areas, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	@GetMapping("/fav-apt/{userId}")
	public ResponseEntity<?> favAptList(@PathVariable("userId") String userId) {
		List<AptInfo> list;
		
		AptInfo temp;
		try {
			list = aptService.favAptCodeList(userId);
			
			return new ResponseEntity<List<AptInfo>>(list, HttpStatus.OK);

		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	

	
}
