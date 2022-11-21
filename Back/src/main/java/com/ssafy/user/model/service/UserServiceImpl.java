package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.dto.MailDTO;
import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	UserMapper userMapper;
	JavaMailSender mailSender;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper, JavaMailSender mailSender) {
		super();
		this.userMapper = userMapper;
		this.mailSender = mailSender;
	}

	@Override
	public int insert(User user) throws SQLException {
		return userMapper.insert(user);
	}

	@Override
	public User login(User user) throws SQLException {
		return userMapper.login(user);
	}

	@Override
	public void update(User user) throws SQLException {
		userMapper.update(user);
	}

	@Override
	public void delete(String id) throws SQLException {
		userMapper.delete(id);
	}
	
	//비밀번호 찾기
	@Override
	public void findpw(String id) throws SQLException {
		User user = userMapper.getUser(id);
		String userEmail = user.getEmail();
		String temPass = getTempPassword();
		MailDTO mailDto = createMailAndChangePassword(temPass, userEmail);
		updatePassword(temPass, user.getUserId());
		mailSend(mailDto);
	}
	
	@Override
	public MailDTO createMailAndChangePassword(String str, String memberEmail) {
        MailDTO dto = new MailDTO();
        dto.setAddress(memberEmail);
        dto.setTitle("House Party 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. House Party 임시비밀번호 안내 관련 이메일 입니다." + " 회원님의 임시 비밀번호는 "
                + str + " 입니다." + "로그인 후에 비밀번호를 변경을 해주세요");
        return dto;
	}

	@Override
	public void updatePassword(String temPass, String id) throws SQLException {
		User user = new User();
		user.setUserId(id);
		user.setUserPw(temPass);
		userMapper.updatePw(user);
	}

	@Override
	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
	}

	@Override
	public void mailSend(MailDTO mailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("paul9512@gmail.com");
        message.setTo(mailDTO.getAddress());
        message.setSubject(mailDTO.getTitle());
        message.setText(mailDTO.getMessage());
        message.setReplyTo("paul9512@gmail.com");
        System.out.println("message"+message);
        mailSender.send(message);
	}
	

	@Override
	public List<User> getUserList() throws SQLException {
		return userMapper.getUserList();
	}

	@Override
	public User getUser(String id) throws SQLException {
		return userMapper.getUser(id);
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return userMapper.getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		userMapper.saveRefreshToken(map);
	}

	

}
