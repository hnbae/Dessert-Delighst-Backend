package com.mysite.dessert_delights.product;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mysite.dessert_delights.DataVO.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private ProductMapper mapper;
	
	public ProductServiceImpl(ProductMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ProductVO> getAllProducts() {
		List<ProductVO> allProducts = new ArrayList<ProductVO>();
		allProducts = mapper.getAllProducts();
		return allProducts;
	}
	
//	@Override
//	public List<ProductVO> getCategorizedProducts(String category, int page_num, int limit) {
//		int start = (page_num - 1)*limit;
//		List<ProductVO> Products = new ArrayList<ProductVO>();
//		Products = mapper.getCategorizedProducts(category, start, limit);
//		return Products;
//	}
	
	@Override
	public List<ProductVO> getCategorizedProducts(String category) {
		List<ProductVO> Products = new ArrayList<ProductVO>();
		Products = mapper.getCategorizedProducts(category);
		return Products;
	}
	
	@Override
	public List<ProductVO> getNewArrivals(){
		List<ProductVO> newArrivals=new ArrayList<ProductVO>();
		newArrivals=mapper.getNewArrivals();
		return newArrivals;
	}
	
	@Override
	public List<ProductVO> getHotItems(){
		List<ProductVO> hotItems=new ArrayList<ProductVO>();
		hotItems=mapper.getHotItems();
		return hotItems;
	}
	
	@Override
	public ProductVO getProduct(String pid) {
		ProductVO product = new ProductVO();
		product = mapper.getProduct(pid);
		return product;
	}
	
	@Override
	public List<ProductVO> getSearchProduct(String keyword){
		List<ProductVO> searchProduct=new ArrayList<ProductVO>();
		searchProduct=mapper.getSearchProduct(keyword);
		return searchProduct;
	}
	
	@Override
	public boolean addProduct(ProductVO productvo) {
		return mapper.addProduct(productvo);
	}
	
	@Override
	public boolean modifyProduct(ProductVO productvo) {
		return mapper.modifyProduct(productvo);
	}
	
	@Override
	public boolean deleteProduct(String pid) {
		return mapper.deleteProduct(pid);
	}
	
	@Override
	public ProductVO getRemoved(String pid) {
		return mapper.getRemoved(pid);
	}

}
