package com.mysite.dessert_delights.DataVO;

import lombok.Data;

@Data
public class ShipmentVO {
	private int shipindex;
	private String ordno;
	private String shipstatus;
	private String orderer;
	private String ordrphone;
	private String recipient;
	private String reciphone;
	private String reciaddress;
	private String request;
}