package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.user.model.dto.MailDTO;
import com.ssafy.user.model.dto.User;

public interface UserService {

	int insert(User user) throws SQLException;
	User login(User user) throws SQLException;
	void update(User user) throws SQLException;
	void delete(String id) throws SQLException;
	
	//findpw
	void findpw(String id) throws SQLException;
	MailDTO createMailAndChangePassword(String tempPass, String memberEmail);
	void updatePassword(String str, String userEmail) throws SQLException;
	String getTempPassword();
	void mailSend(MailDTO mailDTO);
	
	//token
	public void saveRefreshToken(String userid, String refreshToken) throws Exception;
	public Object getRefreshToken(String userid) throws Exception;
	public void deleRefreshToken(String userid) throws Exception;
	
	/* Admin */
	List<User> getUserList() throws SQLException;
	User getUser(String id) throws SQLException;
}
