package com.mysite.dessert_delights.DataVO;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String authority;
	private String name;
	private String nickname;
	private String phone;
	private Date birth;
	private String email;
	private String address;
}
