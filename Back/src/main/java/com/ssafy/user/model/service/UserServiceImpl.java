package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.mapper.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	UserMapper userMapper;

	@Override
	public int insert(User user) throws SQLException {
		return userMapper.insert(user);
	}

	@Override
	public User login(Map<String, String> map) throws SQLException {
		return userMapper.login(map);
	}

	@Override
	public void update(User user) throws SQLException {
		userMapper.update(user);
	}

	@Override
	public void delete(String id) throws SQLException {
		userMapper.delete(id);
	}

	@Override
	public void findpw(String id) throws SQLException {
		userMapper.findpw(id);
	}

	@Override
	public List<User> getUserList() throws SQLException {
		return userMapper.getUserList();
	}

	@Override
	public User getUser(String id) throws SQLException {
		return userMapper.getUser(id);
	}

}
