package com.ssafy.user.jwt.service;

import java.util.Map;

public interface JwtService {

	<T> String createAccessToken(String key1, T data1, String key2, T data2);
	<T> String createRefreshToken(String key1, T data1, String key2, T data2);
	<T> String create(String key1, T data1, String key2, T data2, String subject, long expir);
	Map<String, Object> get(String key);
	String getUserId();
	boolean checkToken(String jwt);
	
}
