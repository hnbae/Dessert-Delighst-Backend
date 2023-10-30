package com.mysite.dessert_delights.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.dessert_delights.DataVO.CartVO;

@RestController
public class CartController {
private CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@RequestMapping("/getCartList")
	public List<CartVO> getCartList(@RequestParam String mid) {
	    List<CartVO> vo = cartService.getCartList(mid);
		return vo;
	}
	
	
	@RequestMapping("/addCart")
	public boolean addCart(@RequestBody CartVO cartvo) {
		return cartService.addCart(cartvo);
	}
	
	@RequestMapping("/setCartCntUpdate")
	public boolean setCartCntUpdate(@RequestBody CartVO cartvo) {
		return cartService.setCartCntUpdate(cartvo);
	}
	
	@RequestMapping("/deleteCart")
	public boolean deleteCart(@RequestBody int cartindex) {
		return cartService.deleteCart(cartindex);
	}

}
