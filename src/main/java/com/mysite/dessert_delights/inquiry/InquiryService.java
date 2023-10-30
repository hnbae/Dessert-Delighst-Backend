package com.mysite.dessert_delights.inquiry;

import java.util.HashMap;
import java.util.List;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;

public interface InquiryService {
	public boolean insertInquiry(InquiryVO inquiryVO);
	
	public HashMap<String, List<FaqVO>> getFaqs();
	public FaqVO getFaq(FaqVO faqVO);
	public boolean insertFaq(FaqVO faqVO);
	public boolean deleteFaq(int faqIndex);
}
