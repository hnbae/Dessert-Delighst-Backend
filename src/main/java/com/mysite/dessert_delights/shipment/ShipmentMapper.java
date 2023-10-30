package com.mysite.dessert_delights.shipment;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.dessert_delights.DataVO.ProductVO;
import com.mysite.dessert_delights.DataVO.ShipmentVO;

@Mapper
public interface ShipmentMapper {
	
	//shipIndex에 대한 배송 정보를 조회
	@Select("SELECT * FROM shipment WHERE shipIndex=#{shipIndex}")
	public ShipmentVO getShipmentList(@Param("shipIndex") int shipIndex);
	
	//배송 정보 삽입
	@Insert("INSERT INTO shipment VALUES(null, #{ordNo}, #{shipStatus}, #{orderer}, #{ordrPhone}, #{recipient}, #{reciPhone}, #{reciAddress}, #{request}, 'shipment')")
	public boolean addShipment(ShipmentVO shipmentvo);
	
	//배송 정보 수정
	@Update("UPDATE shipment SET ordNo=#{ordNo}, shipStatus=#{shipStatus}, orderer=#{orderer}, ordrPhone=#{ordrPhone}, recipient=#{recipient}, reciPhone=#{reciPhone}, reciAddress=#{reciAddress}, request=#{request] WHERE shipIndex=#{shipIndex}")
	public boolean modifyShipment(ShipmentVO shipmentvo);
	
	//배송 정보 삭제
	@Delete("DELETE FROM shipment WHERE shipIndex=#{shipIndex}")
	public boolean deleteShipment(@Param("shipIndex") int shipIndex);
	
}