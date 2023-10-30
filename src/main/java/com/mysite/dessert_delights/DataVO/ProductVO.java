package com.mysite.dessert_delights.DataVO;

import lombok.Data;

@Data
public class ProductVO {
	private String pid;
	private String category;
    private String pname;
    private String poption;
    private int pprice;
    private int extrafee;
    private float prate;
    private int sales;
    private int stock;
    private String details;
    private String imgsrc;
    private String dimgsrc;
    private String pdate;
}
