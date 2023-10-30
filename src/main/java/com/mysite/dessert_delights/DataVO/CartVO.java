package com.mysite.dessert_delights.DataVO;

import lombok.Data;

@Data
public class CartVO { // cart와 product를 join한 테이블
	// cart 테이블 칼럼
	private int cartindex;
	private String mid;
	private String pid;
	private int cnt;
	
	// product 테이블 칼럼
	private String category;
	private String pname; 
	private String poption;
	private int pprice;
	private int extrafee;
	private String imgsrc;
}