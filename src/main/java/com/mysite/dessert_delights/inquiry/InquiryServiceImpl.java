package com.mysite.dessert_delights.inquiry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;

@Service("inquiryService")
public class InquiryServiceImpl implements InquiryService {
	
	private InquiryMapper mapper;

	public InquiryServiceImpl(InquiryMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public boolean insertInquiry(InquiryVO inquiryVO) {
		return mapper.insertInquiry(inquiryVO);
	}

	
	@Override
	public HashMap<String, List<FaqVO>> getFaqs() {
		HashMap<String, List<FaqVO>> faqs = new HashMap<String, List<FaqVO>>();
		List<FaqVO> list = new ArrayList<FaqVO>();
		list = mapper.getFaqs();
		for(FaqVO vo: list) {
			if(!faqs.containsKey(vo.getQcls())) {
				ArrayList<FaqVO> arraylist = new ArrayList<FaqVO>();
				arraylist.add(vo);
				faqs.put(vo.getQcls(), arraylist);
			}
			else {
				faqs.get(vo.getQcls()).add(vo);
			}
		}
		return faqs;
	}
	@Override
	public FaqVO getFaq(FaqVO faqVO) {
		return mapper.getFaq(faqVO);
	}
	@Override
	public boolean insertFaq(FaqVO faqVO) {
		return mapper.insertFaq(faqVO);
	}
	@Override
	public boolean deleteFaq(int faqIndex) {
		return mapper.deleteFaq(faqIndex);
	}
	
}
