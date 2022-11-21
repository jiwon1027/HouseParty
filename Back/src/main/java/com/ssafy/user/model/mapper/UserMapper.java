package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.dto.User;

@Mapper
public interface UserMapper {
	
	int insert(User user) throws SQLException;
	User login(User user) throws SQLException;
	void update(User user) throws SQLException;
	void delete(String id) throws SQLException;
	void findpw(String id) throws SQLException;
	void updatePw(User user) throws SQLException;

	/* Token */
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String userid) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
	/* Admin */
	List<User> getUserList() throws SQLException;
	User getUser(String id) throws SQLException;
}
