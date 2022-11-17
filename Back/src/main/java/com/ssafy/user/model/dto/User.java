package com.ssafy.user.model.dto;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userPw;
	private String name;
	private int age;
	private String email;
}
