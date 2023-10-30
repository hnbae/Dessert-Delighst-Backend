package com.mysite.dessert_delights.DataVO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderTblVO {
	private String ordno;
	private String mid;
	private String payment;
	private LocalDateTime orddate;
	private String ordstatus;
}