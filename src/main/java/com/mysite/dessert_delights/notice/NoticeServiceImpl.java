package com.mysite.dessert_delights.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.dessert_delights.DataVO.FaqVO;
import com.mysite.dessert_delights.DataVO.InquiryVO;
import com.mysite.dessert_delights.DataVO.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	private NoticeMapper mapper;

	public NoticeServiceImpl(NoticeMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<NoticeVO> getAllNoticeList() {
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();
		noticeList = mapper.getAllNoticeList();
		return noticeList;
	}

	@Override
	public NoticeVO getNotice(int noticeindex) {
		NoticeVO notice = new NoticeVO();
		notice = mapper.getNotice(noticeindex);
		return notice;
	}

	@Override
	public NoticeVO readNotice(int noticeindex) {
		NoticeVO notice = new NoticeVO();
		notice = mapper.getNotice(noticeindex);
		mapper.setViewsUpdate(noticeindex);
		return mapper.getNotice(noticeindex);
	}

	@Override
	public boolean insertNotice(NoticeVO notice) {
		return mapper.insertNotice(notice);
	}
	
	@Override
	public boolean updateNotice(NoticeVO notice) {
		return mapper.updateNotice(notice);
	}

	@Override
	public boolean deleteNotice(int noticeindex) {
		return mapper.deleteNotice(noticeindex);
	}

}
