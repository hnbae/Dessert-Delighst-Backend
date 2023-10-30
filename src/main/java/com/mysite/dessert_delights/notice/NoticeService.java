package com.mysite.dessert_delights.notice;

import java.util.List;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;
import com.mysite.dessert_delights.DataVO.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> getAllNoticeList();
	public NoticeVO getNotice(int noticeindex);
	public NoticeVO readNotice(int noticeindex);
	public boolean insertNotice(NoticeVO notice);
	public boolean updateNotice(NoticeVO notice);
	public boolean deleteNotice(int noticeindex);
}
