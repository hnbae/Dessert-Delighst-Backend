package com.mysite.dessert_delights.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.dessert_delights.DataVO.OrderTblVO;

@RestController
public class OrderController {
private OrderService orderTblService;
	
	public OrderController(OrderService orderTblService) {
		this.orderTblService = orderTblService;
	}
	
	@RequestMapping("/getOrderList")
	public List<OrderTblVO> getOrderList(@RequestParam("mid") String mId) {
	    List<OrderTblVO> vo = orderTblService.getOrderList(mId);
		return vo;
	}
	
	@RequestMapping("/getOrderByShipStatus")
	public List<OrderTblVO> getOrderByShipStatus(@RequestParam("shipStatus") String shipStatus) {
	    List<OrderTblVO> vo = orderTblService.getOrderByShipStatus(shipStatus);
		return vo;
	}
	
	@RequestMapping("/getOrderByOrdDate")
	public List<OrderTblVO> getOrderByOrdDate() {
		List<OrderTblVO> vo = orderTblService.getOrderByOrdDate();
		return vo;
	}
	
	@RequestMapping("/getOrderBymId")
	public List<OrderTblVO> getOrderBymId(@RequestParam("mId") String mId) {
		List<OrderTblVO> vo = orderTblService.getOrderBymId(mId);
		return vo;
	}
	
	@RequestMapping("/addOrder")
	public boolean addOrder(@RequestBody OrderTblVO orderTblvo) {
		return orderTblService.addOrder(orderTblvo);
	}
	
	@RequestMapping("/modifyOrder")
	public boolean modifyOrder(@RequestBody OrderTblVO orderTblvo) {
		return orderTblService.modifyOrder(orderTblvo);
	}
	
	@RequestMapping("/deleteOrder")
	public boolean deleteOrder(@RequestBody String ordNo) {
		return orderTblService.deleteOrder(ordNo);
	}

}
