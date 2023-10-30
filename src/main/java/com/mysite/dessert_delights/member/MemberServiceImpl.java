package com.mysite.dessert_delights.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.dessert_delights.DataVO.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;
	
	public MemberServiceImpl(MemberMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = mapper.getMemberList();
		return memberList;
	}
	
	@Override
	public List<MemberVO> getAdminList() {
		List<MemberVO> adminList = new ArrayList<MemberVO>();
		adminList = mapper.getAdminList();
		return adminList;
	}

	@Override
	public boolean checkIdDuplication(String id) {
		int res = mapper.checkIdDuplication(id);
		return (res == 1);
	}

	@Override
	public boolean login(String id, String pw) {
		int res = mapper.login(id, pw);
		return (res == 1);
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO vo = mapper.getMember(id);
		return vo;
	}
	
	@Override
	public boolean signup(MemberVO membervo) {
		return mapper.signup(membervo);
	}

	@Override
	public boolean modifyInfo(MemberVO membervo) {
		return mapper.modifyInfo(membervo);
	}

	@Override
	public boolean deleteMember(String id) {
		return mapper.deleteMember(id);
	}

	@Override
	public boolean giveAdminAuthority(String id) {
		return mapper.giveAdminAuthority(id);
	}

	@Override
	public boolean revokeAdminAuthority(String id) {
		return mapper.revokeAdminAuthority(id);
	}

}
