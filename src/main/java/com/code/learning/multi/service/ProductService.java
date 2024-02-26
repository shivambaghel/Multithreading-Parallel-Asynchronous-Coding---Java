package com.code.learning.multi.service;

import static com.code.learning.multi.util.CommonUtil.stopWatch;
import static com.code.learning.multi.util.LoggerUtil.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.learning.multi.model.Product;
import com.code.learning.multi.model.ProductInfo;
import com.code.learning.multi.model.Review;

@Service
public class ProductService {
	
	@Autowired
    private ProductInfoService productInfoService;
	
	@Autowired
    private ReviewService reviewService;
    
    public Product retrieveProductDetails(String productId) {
		stopWatch.start();

        ProductInfo productInfo = productInfoService.retrieveProductInfo(productId); // blocking call
        Review review = reviewService.retrieveReviews(productId); // blocking call

        stopWatch.stop();
        log("Total Time Taken : "+ stopWatch.getTime());
        return new Product(productId, productInfo, review);
    }
}