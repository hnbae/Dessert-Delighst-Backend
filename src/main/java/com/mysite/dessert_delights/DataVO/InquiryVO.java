package com.mysite.dessert_delights.DataVO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InquiryVO {
	private int inqindex;
	private String qcls;
	private String mid;
	private String inqsubject;
	private String inqcontents;
	private LocalDateTime inqdate;
	private String answer;
	private LocalDateTime answerdate;
}
