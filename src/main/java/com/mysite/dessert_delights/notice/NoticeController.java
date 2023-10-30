package com.mysite.dessert_delights.notice;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;
import com.mysite.dessert_delights.DataVO.NoticeVO;

@RestController
public class NoticeController {
	
	private NoticeService noticeService;
	
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@RequestMapping("/getNoticeList")
	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> vo = noticeService.getAllNoticeList();
		return vo;
	}
	
	@RequestMapping("/getNotice")
	public NoticeVO getNotice(@RequestParam int noticeIndex) {
		NoticeVO vo = new NoticeVO();
		vo = noticeService.getNotice(noticeIndex);
		return vo;
	}
	
	@RequestMapping("/readNotice")
	public NoticeVO readNotice(@RequestParam int noticeIndex) {
		NoticeVO vo = new NoticeVO();
		vo = noticeService.readNotice(noticeIndex);
		return vo;
	}
	
	@RequestMapping("/insertNotice")
	public boolean insertNotice(@RequestBody NoticeVO notice) {
		return noticeService.insertNotice(notice);
	}
	
	@RequestMapping("/updateNotice")
	public boolean updateNotice(@RequestBody NoticeVO notice) {
		return noticeService.updateNotice(notice);
	}
	
	@RequestMapping("/deleteNotice")
	public boolean deleteNotice(@RequestBody int noticeIndex) {
		return noticeService.deleteNotice(noticeIndex);
	}

}
