package com.mysite.dessert_delights.order;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.dessert_delights.DataVO.OrderTblVO;

@Mapper
public interface OrderMapper {
	
	//주문 정보 조회
	@Select("SELECT * FROM orderTbl WHERE mId=#{mid}")
	public List<OrderTblVO> getOrderList(@Param("mid") String mid);
	
	//특정 배송 상태에 해당하는 주문 리스트 조회
	@Select("SELECT o.* FROM ordTbl o JOIN shipment s ON o.ordNo = s.ordNo WHERE s.shipStatus = #{shipstatus}")
	public List<OrderTblVO> getOrderByShipStatus(@Param("shipstatus") String shipstatus);
	
	//특정 기간 동안의 주문 정보와 배송 정보를 함께 조회
	@Select("SELECT * FROM ordTbl o JOIN shipment s ON o.ordNo = s.ordNo WHERE o.ordDate BETWEEN DATE_SUB(NOW(), INTERVAL 6 MONTH) AND DATE_SUB(NOW(), INTERVAL 3 MONTH)")
	public List<OrderTblVO> getOrderByOrdDate();
	
	//주문한 상품 정보 조회
	@Select("SELECT p.*, ol.cnt FROM ordTbl o JOIN orderlist ol ON o.ordNo = ol.ordNo JOIN product p ON ol.pId = p.pId"
			+"WHERE o.mId=#{mId}")
	public List<OrderTblVO> getOrderBymId(@Param("mId") String mid);
	
	//주문 정보 추가
	@Insert("INSERT INTO orderTbl VALUES(#{ordNo}, #{mId}, #{payment}, #{ordDate}, #{ordStatus}, 'orderTbl')")
	public boolean addOrder(OrderTblVO ordertblvo);
	
	//주문 정보 수정
	@Update("UPDATE orderTbl SET mId=#{mId}, payment=#{payment}, ordDate=#{ordDate}, ordStatus=#{ordStatus} WHERE ordNo=#{ordNo}")
	public boolean modifyOrder(OrderTblVO ordertblvo);
	
	//주문 정보 삭제
	@Delete("DELETE FROM orderTbl WHERE ordNo=#{ordNo}")
	public boolean deleteOrder(@Param("ordNo") String ordno);
	
}
