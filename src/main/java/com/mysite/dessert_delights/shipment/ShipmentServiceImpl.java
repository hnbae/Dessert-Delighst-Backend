package com.mysite.dessert_delights.shipment;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mysite.dessert_delights.DataVO.ShipmentVO;

@Service("shipmentService")
public class ShipmentServiceImpl implements ShipmentService{
	
	private ShipmentMapper mapper;
	
	public ShipmentServiceImpl(ShipmentMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public ShipmentVO getShipmentList(int shipIndex) {
		ShipmentVO shipment = new ShipmentVO();
		shipment = mapper.getShipmentList(shipIndex);
		return shipment;
	}

	@Override
	public boolean addShipment(ShipmentVO shipmentvo) {
		return mapper.addShipment(shipmentvo);
	}
	
	@Override
	public boolean modifyShipment(ShipmentVO shipmentvo) {
		return mapper.modifyShipment(shipmentvo);
	}
	
	@Override
	public boolean deleteShipment(int shipIndex) {
		return mapper.deleteShipment(shipIndex);
	}
	
}
