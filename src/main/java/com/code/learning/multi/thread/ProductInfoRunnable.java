package com.code.learning.multi.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.code.learning.multi.model.ProductInfo;
import com.code.learning.multi.service.ProductInfoService;

@Component
public class ProductInfoRunnable implements Runnable {

	@Autowired
	private ProductInfoService productInfoService;

	private String productId;
	private ProductInfo productInfo;

	public void setProductInfo(String productId) {
		this.productId = productId;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}
	@Override
	public void run() {
		productInfo = productInfoService.retrieveProductInfo(productId);
	}
}