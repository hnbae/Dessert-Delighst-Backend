package com.mysite.dessert_delights.product;

import com.mysite.dessert_delights.DataVO.ReviewVO;

import lombok.Data;

@Data
public class ProductReviewVO extends ReviewVO{
	private String nickname;
}
