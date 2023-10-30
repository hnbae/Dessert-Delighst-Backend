package com.mysite.dessert_delights.DataVO;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticeindex;
	private String mid;
	private String authority; // notice n join member m on n.mId=m.id으로 조회할 예정
	private String nickname; // notice n join member m on n.mId=m.id으로 조회할 예정
	private String noticesubject;
	private String noticecontents;
	private String noticedate;
	private int views;
}
