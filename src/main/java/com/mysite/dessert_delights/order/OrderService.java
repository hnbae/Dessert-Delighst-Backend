package com.mysite.dessert_delights.order;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.mysite.dessert_delights.DataVO.OrderTblVO;

public interface OrderService {
	public List<OrderTblVO> getOrderList(String mId);
	public List<OrderTblVO> getOrderByShipStatus(String shipStatus);
	public List<OrderTblVO> getOrderByOrdDate();
	public List<OrderTblVO> getOrderBymId(String mId);
	public boolean addOrder(OrderTblVO orderTblvo);
	public boolean modifyOrder(OrderTblVO orderTblvo);
	public boolean deleteOrder(@Param("ordNo")String ordNo);
}
//public ProductVO getProduct(String pId);