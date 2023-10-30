package com.mysite.dessert_delights.product;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.dessert_delights.DataVO.ProductVO;

@RestController
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/getAllProducts")
	public List<ProductVO> getAllProducts() {
		List<ProductVO> list = productService.getAllProducts();
		return list;
	}
	
//	@RequestMapping("/getCategorizedProducts")
//	public List<ProductVO> getCategorizedProducts(@RequestParam("category")String category, @RequestParam("pageNum")int pageNum, @RequestParam("limit")int limit) {
//		List<ProductVO> list = productService.getCategorizedProducts(category, pageNum, limit);
//		return list;
//	}
	@RequestMapping("/getCategorizedProducts")
	public List<ProductVO> getCategorizedProducts(@RequestParam("category")String category) {
		List<ProductVO> list = productService.getCategorizedProducts(category);
		return list;
	}
	
	@RequestMapping("/getNewArrivals")
	public List<ProductVO> getNewArrivals(){
		List<ProductVO> list = productService.getNewArrivals();
		return list;
	}
	
	
	@RequestMapping("/getHotItems")
	public List<ProductVO> getHotItems(){
		List<ProductVO> list = productService.getHotItems();
		return list;
	}
	
	@RequestMapping("/getProduct")
	public ProductVO getProduct(@RequestParam String pid){
		return productService.getProduct(pid);
	}
	
	
	@RequestMapping("/getSearchProduct")
	public List<ProductVO> getSearchProduct(@RequestParam String keyword){
		List<ProductVO> list = productService.getSearchProduct(keyword);
		return list;
	}
	
	@RequestMapping("/addProduct")
	public boolean addProduct(@RequestBody ProductVO productvo) {
		return productService.addProduct(productvo);
	}
	
	@RequestMapping("/modifyProduct")
	public boolean modifyInfo(@RequestBody ProductVO productvo) {
		return productService.modifyProduct(productvo);
	}
	
	@RequestMapping("/deleteProduct")
	public boolean deleteProduct(@RequestBody String pid) {
		return productService.deleteProduct(pid);
	}
	
	@RequestMapping("/removed")
	public ProductVO getRemoved(@RequestBody String pid) {
		return productService.getRemoved(pid);
	}
	
	
}
