package com.mysite.dessert_delights.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mysite.dessert_delights.DataVO.ProductVO;

public interface ProductService {
	public List<ProductVO> getAllProducts();
//	public List<ProductVO> getCategorizedProducts(String category, int page_num, int limit);
	public List<ProductVO> getCategorizedProducts(String category);
	public List<ProductVO> getNewArrivals();
	public List<ProductVO> getHotItems();
	public ProductVO getProduct(String pid);
	public List<ProductVO> getSearchProduct(String keyword);
	public boolean addProduct(ProductVO productvo);
	public boolean modifyProduct(ProductVO productvo);
	public boolean deleteProduct(String pid);
	public ProductVO getRemoved(String pid);
}
