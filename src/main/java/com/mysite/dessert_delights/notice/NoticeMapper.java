package com.mysite.dessert_delights.notice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;
import com.mysite.dessert_delights.DataVO.NoticeVO;

@Mapper
public interface NoticeMapper {
	
	//noticePage (NoticeVO: notice테이블과 member테이블을 join해서 얻은 테이블값을 가짐)
	@Select("SELECT noticeindex, mid, authority, nickname, noticesubject, noticecontents, noticedate, views "
			+ "FROM notice N inner join member M on N.mid = M.id ORDER BY noticeindex DESC")
	public List<NoticeVO> getAllNoticeList();
	
	@Select("SELECT noticeindex, mid, authority, nickname, noticesubject, noticecontents, noticedate, views "
			+ "FROM notice N inner join member M on N.mid = M.id where noticeindex=#{noticeindex}")
	public NoticeVO getNotice(@Param("noticeindex") int noticeindex);
	
	@Update("update notice set views=views+1 where noticeindex=#{noticeindex}")
	public boolean setViewsUpdate(@Param("noticeindex") int noticeindex);
	
	@Insert("INSERT INTO notice(mid, noticesubject, noticecontents, noticedate, views) "
			+ "values (#{mid}, #{noticesubject}, #{noticecontents}, now(), 0)")
	public boolean insertNotice(NoticeVO notice);
	
	@Update("update notice set noticesubject=#{noticesubject}, noticecontents=#{noticecontents} where noticeIndex=#{noticeindex}")
	public boolean updateNotice(NoticeVO notice);
	
	@Delete("Delete from notice where noticeindex=#{noticeindex}")
	public boolean deleteNotice(@Param("noticeindex") int noticeindex);
	
}
