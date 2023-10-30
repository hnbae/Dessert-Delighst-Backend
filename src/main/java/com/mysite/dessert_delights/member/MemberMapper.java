package com.mysite.dessert_delights.member;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.dessert_delights.DataVO.MemberVO;

@Mapper
public interface MemberMapper {

	// 회원만 출력
	@Select("select * from member where authority='member' ORDER BY id") 
	public List<MemberVO> getMemberList();
	
	// 관리자만 출력
	@Select("select * from member where authority='admin' ORDER BY id")
	public List<MemberVO> getAdminList();
	
	// 아이디 체크 쿼리문(지금은 int 지만 boolean으로 바꿔서 t/f로 나오게 할 예정(아이디가 중복이면 t, 아니면 f로 나오게 할 예정)
	@Select("select count(*) from member where id=#{id}")
	public int checkIdDuplication(@Param("id") String id);
	
	// 로그인 쿼리(아이디 비번을 입력했을 떄 일치하는 데이터가 있는지 확인,일치하면 1이 나옴)
	// 아이디 값은 session에 저장하게 할 예정
	@Select("select count(*) from member where id=#{id} and pw=#{pw}")
	public int login(@Param("id") String id, @Param("pw") String pw);

	// 아이디랑 일치하는 회원정보를 가져오는 쿼리
	@Select("select * from member where id=#{id}")
	public MemberVO getMember(@Param("id") String id);
	
	// 회원가입 쿼리(개인정보니까 axios에서 post로 입력해야한대->이건 vs에서)
	@Insert("insert into member values(#{id}, #{pw}, #{name}, #{nickname}, #{birth}, #{email}, #{phone}, #{address}, 'member')")
	public boolean signup(MemberVO membervo);
	
	// 회원정보 수정(마찬가지로 post로 하면 됨)
	@Update("update member set pw=#{pw}, nickname=#{nickname}, birth=#{birth}, email=#{email}, phone=#{phone}, address=#{address} where id=#{id}")
	public boolean modifyInfo(MemberVO membervo);
	
	// 권한 부여
	@Update("update member set authority='admin' where id=#{id}")
	public boolean giveAdminAuthority(@Param("id") String id);
	
	// 권한 삭제
	@Update("update member set authority='member' where id=#{id}")
	public boolean revokeAdminAuthority(@Param("id") String id);
	
	// 삭제(마찬가지로 post)
	@Delete("delete from member where authority='member' and id=#{id}")
	public boolean deleteMember(@Param("id") String id);
	
}
