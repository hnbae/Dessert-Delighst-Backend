package com.mysite.dessert_delights.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mysite.dessert_delights.DataVO.CartVO;

public interface CartService {
	public List<CartVO> getCartList(String mid);
	public boolean addCart(CartVO cartvo);
	public boolean setCartCntUpdate(CartVO cartvo);
	public boolean deleteCart(int cartindex);

}