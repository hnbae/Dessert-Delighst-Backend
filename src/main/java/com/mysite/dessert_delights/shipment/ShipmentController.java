package com.mysite.dessert_delights.shipment;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.dessert_delights.DataVO.ShipmentVO;

@RestController
public class ShipmentController {
private ShipmentService shipmentService;
	
	public ShipmentController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	@RequestMapping("/getShipmentList")
	public ShipmentVO getShipmentList(@RequestParam("shipIndex") int shipIndex) {
		return shipmentService.getShipmentList(shipIndex);
	}
	
	@RequestMapping("/addShipment")
	public boolean addShipment(@RequestBody ShipmentVO shipmentvo) {
		return shipmentService.addShipment(shipmentvo);
	}
	
	@RequestMapping("/modifyShipment")
	public boolean modifyShipment(@RequestBody ShipmentVO shipmentvo) {
		return shipmentService.modifyShipment(shipmentvo);
	}
	
	@RequestMapping("/deleteShipment")
	public boolean deleteShipment(@RequestBody int shipIndex) {
		return shipmentService.deleteShipment(shipIndex);
	}

}
