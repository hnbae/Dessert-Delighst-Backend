package com.mysite.dessert_delights.order;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mysite.dessert_delights.DataVO.OrderTblVO;

@Service("orderTblService")
public class OrderServiceImpl implements OrderService{
	
	private OrderMapper mapper;
	
	public OrderServiceImpl(OrderMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<OrderTblVO> getOrderList(String mId) {
		List<OrderTblVO> orderTbl = new ArrayList<OrderTblVO>();
		orderTbl = mapper.getOrderList(mId);
		return orderTbl;
	}
	
	@Override
	public List<OrderTblVO> getOrderByShipStatus(String shipStatus) {
		List<OrderTblVO> orderTbl = new ArrayList<OrderTblVO>();
		orderTbl = mapper.getOrderByShipStatus(shipStatus);
		return orderTbl;
	}
	
	 @Override
	 public List<OrderTblVO> getOrderByOrdDate() {
		List<OrderTblVO> orderTbl = new ArrayList<OrderTblVO>();
	    return orderTbl;
	    }
	 
	@Override
	public List<OrderTblVO> getOrderBymId(String mId) {
		List<OrderTblVO> orderBymId = new ArrayList<OrderTblVO>();
		orderBymId = mapper.getOrderBymId(mId);
		return orderBymId;
	}

	@Override
	public boolean addOrder(OrderTblVO orderTblvo) {
		return mapper.addOrder(orderTblvo);
	}
	
	@Override
	public boolean modifyOrder(OrderTblVO orderTblvo) {
		return mapper.modifyOrder(orderTblvo);
	}
	
	@Override
	public boolean deleteOrder(String ordNo) {
		return mapper.deleteOrder(ordNo);
	}
	
}
