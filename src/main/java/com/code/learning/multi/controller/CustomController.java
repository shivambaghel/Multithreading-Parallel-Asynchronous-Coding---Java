package com.code.learning.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.learning.multi.model.Product;
import com.code.learning.multi.model.ProductInfo;
import com.code.learning.multi.model.Review;
import com.code.learning.multi.service.ProductInfoService;
import com.code.learning.multi.service.ProductService;
import com.code.learning.multi.service.ReviewService;
import com.code.learning.multi.thread.ProductServiceUsingThread;
import com.code.learning.multi.util.Modules;


@RestController
public class CustomController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ProductInfoService productInfoService;
	
	@Autowired
	private ProductServiceUsingThread productServiceUsingThread;
	
	@GetMapping("/get/product/{productId}")
	public Product getProduct(@PathVariable("productId") String productId, @RequestParam Modules module){
		if (module.equals(Modules.thread)) {
			return productServiceUsingThread.retrieveProductDetails(productId);
		}
		return productService.retrieveProductDetails(productId);
	}
	
	
	// Helper/- instead of DB we have created ProductInfoService & ReviewService classes
	@GetMapping("/get/product/info/{productId}")
	public ProductInfo getProductInfo(@PathVariable("productId") String productId) {
		return productInfoService.retrieveProductInfo(productId);
	}
	
	@GetMapping("/get/review/{productId}")
	public Review getReview(@PathVariable("productId") String productId) {
		return reviewService.retrieveReviews(productId);
	}
}
