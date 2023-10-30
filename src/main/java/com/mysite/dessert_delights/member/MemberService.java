package com.mysite.dessert_delights.member;

import java.util.List;

import com.mysite.dessert_delights.DataVO.MemberVO;

public interface MemberService {
	public List<MemberVO> getMemberList();
	public List<MemberVO> getAdminList();
	public boolean checkIdDuplication(String id);
	public boolean login(String id, String pw);
	public MemberVO getMember(String id);
	public boolean signup(MemberVO membervo);
	public boolean modifyInfo(MemberVO membervo);
	public boolean giveAdminAuthority(String id);
	public boolean revokeAdminAuthority(String id);
	public boolean deleteMember(String id);
}
