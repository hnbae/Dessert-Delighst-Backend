package com.mysite.dessert_delights.inquiry;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;

@Mapper
public interface InquiryMapper {
	//inquiryPage
	@Insert("insert into inquiry(qCls, mid, inqSubject, inqContents, inqDate) values(#{qCls}, #{mId}, #{inqSubject}, #{inqContents}, now())")
	public boolean insertInquiry(InquiryVO inquiryVO);
	
	//FAQ page
	@Select("select * from faq")
	public List<FaqVO> getFaqs();
	
	@Select("select * from faq where faqindex=#{faqindex}")
	public FaqVO getFaq(FaqVO faqVO);
	
	@Insert("insert into faq values(null, #{qcls}, #{faqsubject}, #{faqanswer})")
	public boolean insertFaq(FaqVO faqVO);
	
	@Delete("Delete from faq where faqIndex=#{faqIndex}")
	public boolean deleteFaq(@Param("faqIndex") int faqIndex);
	
	
}
