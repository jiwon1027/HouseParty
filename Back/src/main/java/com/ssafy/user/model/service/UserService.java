package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.user.model.dto.User;

public interface UserService {

	int insert(User user) throws SQLException;
	User login(User user) throws SQLException;
	void update(User user) throws SQLException;
	void delete(String id) throws SQLException;
	
	//findpw
	String findpw(String id) throws SQLException;
	void updatePassword(String str, String userEmail) throws SQLException;
	String getTempPassword();
	
	//token
	public void saveRefreshToken(String userid, String refreshToken) throws Exception;
	public Object getRefreshToken(String userid) throws Exception;
	public void deleRefreshToken(String userid) throws Exception;
	
	/* Admin */
	List<User> getUserList() throws SQLException;
	User getUser(String id) throws SQLException;
}
