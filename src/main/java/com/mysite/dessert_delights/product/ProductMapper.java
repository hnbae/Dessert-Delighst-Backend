package com.mysite.dessert_delights.product;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.dessert_delights.DataVO.ProductVO;

@Mapper
public interface ProductMapper {
	
	//상품을 카테고리 id 기준으로 오름차순 정렬
	@Select("SELECT * FROM product WHERE removed = false ORDER BY category, pid")
	public List<ProductVO> getAllProducts();
	
	//카테고리별 상품을 id 기준으로 오름차순 정렬 후 10개씩 출력
//	@Select("SELECT * FROM product where category=#{category} and pId like '%-01' ORDER BY pId limit #{start}, #{limit}")
//	public List<ProductVO> getCategorizedProducts(@Param("category") String category, @Param("start") int start, @Param("limit") int limit);
	
	//카테고리별 상품을 id 기준으로 오름차순 정렬 후 모두 출력
	@Select("SELECT * FROM product WHERE removed = false AND category=#{category} AND pid like '%-01' ORDER BY pid")
	public List<ProductVO> getCategorizedProducts(@Param("category") String category);
	
	// 최근 10개를 조회
	@Select("SELECT * FROM product WHERE removed = false ORDER BY pDate DESC LIMIT 10")
	public List<ProductVO> getNewArrivals();
	
	// 가장 많이 팔린 10개를 조회
	@Select("SELECT * FROM product WHERE removed = false ORDER BY sales DESC limit 10")
	public List<ProductVO> getHotItems();
	

	// 상품 조회
	@Select("select * from product WHERE removed = false AND pid=#{pid}")

	public ProductVO getProduct(@Param("pid") String pid);
	//출력값이 1개인 것들은 List빼기
	
	// 상품세부설명페이지에 필요한 데이터 조회
	//@Select("select p.*,r. from product p, review r, where r.pId=#{pid} and p.pId=r.pId and ")
	
	//검색어에 따른 상품 목록 조회
	@Select("SELECT * FROM product WHERE removed = false AND LOWER(pName) LIKE CONCAT('%', #{keyword}, '%') "
			+ "or lower(category) like CONCAT('%', #{keyword}, '%') or lower(details) like CONCAT('%', #{keyword}, '%')")
	public List<ProductVO> getSearchProduct(@Param("keyword") String keyword);
	
	//새로운 상품 등록(상품 등록 성공하면 t, 아니면 f)
	@Insert("INSERT INTO product VALUES(#{pid}, #{category}, #{pname}, #{poption}, #{price}, #{extrafee}, #{rate}, #{sales}, #{stock}, #{details}, #{imgsrc}, #{dimgsrc}, now(), false)")
	public boolean addProduct(ProductVO productvo);
	
	//상품 정보 수정(상품 수정 성공하면 t, 아니면 f)
	@Update("UPDATE product SET category=#{category}, pname = #{pname}, poption = #{poption}, price=#{price}, extrafee = #{extrafee},"
			+ " stock=#{stock}, details=#{details}, imgsrc=#{imgsrc}, dimgsrc=#{dimgsrc} WHERE pid = #{pid}")
	public boolean modifyProduct(ProductVO productvo);

	//상품 삭제
	@Update("UPDATE product SET removed = true WHERE pid = #{pid}" )

	public boolean deleteProduct(@Param("pid")String pid);
	
	//삭제 되었는지 확인(true면 삭제)
	@Select("SELECT * FROM product WHERE removed = true AND pid = #{pid} ")
	public ProductVO getRemoved(@Param("pid") String pid);


}
