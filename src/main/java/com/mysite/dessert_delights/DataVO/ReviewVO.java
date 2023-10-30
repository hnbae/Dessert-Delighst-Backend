package com.mysite.dessert_delights.DataVO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReviewVO {
	private int revwindex;
	private String mid;
	private String pid;
	private LocalDateTime revwdate;
	private float rate;
	private String title;
	private String comments;
}