package com.mysite.dessert_delights.inquiry;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;
import com.mysite.dessert_delights.DataVO.NoticeVO;

@RestController
public class InquiryController {
	
	private InquiryService inquiryService;
	
	public InquiryController(InquiryService noticeService) {
		this.inquiryService = noticeService;
	}

	@RequestMapping("/insertInquiry")
	public boolean insertInquiry(InquiryVO inquiryVO) {
		return inquiryService.insertInquiry(inquiryVO);        
	}                                                  
	               
	
	@RequestMapping("/getFaqs")
	public HashMap<String, List<FaqVO>> getFaqs() {
		return inquiryService.getFaqs();
	}
	@RequestMapping("/getFaq")
	public FaqVO getFaq(@RequestBody FaqVO faqVO) {
		return inquiryService.getFaq(faqVO);
	}
	@RequestMapping("/insertFaq")                                          
	public boolean insertFaq(@RequestBody FaqVO faqVO) {            
		return inquiryService.insertFaq(faqVO);                
	}                                                  
	@RequestMapping("/deleteFaq")                                          
	public boolean deleteFaq(int faqIndex) {           
		return inquiryService.deleteFaq(faqIndex);             
	}                                                  
}
