package com.mysite.dessert_delights.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.dessert_delights.DataVO.CartVO;
import com.mysite.dessert_delights.DataVO.ProductVO;

@Service("cartService")
public class CartServiceImpl implements CartService{
	
	private CartMapper mapper;
	
	public CartServiceImpl(CartMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<CartVO> getCartList(String mid) {
		List<CartVO> cartlist = new ArrayList<CartVO>();
		cartlist = mapper.getCartList(mid);
		return cartlist;
	}

	@Override
	public boolean addCart(CartVO cartvo) {
		return mapper.addCart(cartvo);
	}
	
	@Override
	public boolean setCartCntUpdate(CartVO cartvo) {
		return mapper.setCartCntUpdate(cartvo);
	}
	
	@Override
	public boolean deleteCart(int cartindex) {
		return mapper.deleteCart(cartindex);
	}
	
}
