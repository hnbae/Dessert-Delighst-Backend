package com.mysite.dessert_delights.shipment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mysite.dessert_delights.DataVO.ShipmentVO;

public interface ShipmentService {
	public ShipmentVO getShipmentList(int shipIndex);
	public boolean addShipment(ShipmentVO shipmentvo);
	public boolean modifyShipment(ShipmentVO shipmentvo);
	public boolean deleteShipment(@Param("shipIndex")int shipIndex);

}