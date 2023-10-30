package com.mysite.dessert_delights.cart;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.dessert_delights.DataVO.CartVO;

@Mapper
public interface CartMapper {
	
	//장바구니 조회
	@Select("select cartindex, mid, c.pid, cnt, p.category, p.pname, p.poption, p.pprice, p.extrafee, p.imgsrc "
			+ "from cart c inner join product p on c.pid=p.pid where mid=#{mid}")
	public List<CartVO> getCartList(@Param("mid") String mid);
	
	
	//장바구니에 상품 추가
	@Insert("INSERT INTO cart VALUES(null, #{mid}, #{pid}, #{cnt})")
	public boolean addCart(CartVO cartvo);
	
	//장바구니 상품 수량 변경
	@Update("UPDATE cart SET cnt=#{cnt} WHERE cartindex=#{cartindex}")
	public boolean setCartCntUpdate(CartVO cartvo);
	
	//장바구니 상품 삭제
	@Delete("DELETE FROM cart WHERE cartindex=#{cartindex}")
	public boolean deleteCart(@Param("cartindex") int cartindex);
	
}