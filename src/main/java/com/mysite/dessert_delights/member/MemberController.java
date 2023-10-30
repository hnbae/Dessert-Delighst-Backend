package com.mysite.dessert_delights.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.dessert_delights.DataVO.MemberVO;

@RestController
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/getMemberList")
	public List<MemberVO> getMemberList() {
		List<MemberVO> vo = memberService.getMemberList();
		return vo;
	}
	
	@RequestMapping("/getAdminList")
	public List<MemberVO> getAdminList() {
		List<MemberVO> vo = memberService.getAdminList();
		return vo;
	}
	
	@RequestMapping("/checkIdDuplication")
	public boolean checkIdDuplication(String id) {
		return memberService.checkIdDuplication(id);
	}

	//
	@RequestMapping("/login")
	public boolean login(@RequestBody MemberVO vo) {
		return memberService.login(vo.getId(), vo.getPw());
	}

	@RequestMapping("/getMember")
	public MemberVO getMember(@RequestParam String id) {
		MemberVO vo = new MemberVO();
		vo = memberService.getMember(id);
		return vo;
	}
	
	@RequestMapping("/signup")
	public boolean signup(MemberVO membervo) {
		return memberService.signup(membervo);
	}

	@RequestMapping("/modifyInfo")
	public boolean modifyInfo(@RequestBody MemberVO membervo) {
		return memberService.modifyInfo(membervo);
	}
	
	@RequestMapping("/giveAdminAuthority")
	public boolean giveAdminAuthority(String id) {
		return memberService.giveAdminAuthority(id);
	}
	
	@RequestMapping("/revokeAdminAuthority")
	public boolean revokeAdminAuthority(MemberVO membervo) {
		return memberService.modifyInfo(membervo);
	}

	@RequestMapping("/deleteMember")
	public boolean deleteMember(String id) {
		return memberService.deleteMember(id);
	}
	
}
