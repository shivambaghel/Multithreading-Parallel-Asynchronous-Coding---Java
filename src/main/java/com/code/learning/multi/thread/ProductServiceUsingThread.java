package com.code.learning.multi.thread;

import com.code.learning.multi.model.Product;

import static com.code.learning.multi.util.LoggerUtil.*;

import org.springframework.stereotype.Component;

import static com.code.learning.multi.util.CommonUtil.*;

@Component
public class ProductServiceUsingThread {

	public Product retrieveProductDetails(String productId){
		try {
			stopWatch.start();
			ProductInfoRunnable productInfoRunnable = new ProductInfoRunnable();
			productInfoRunnable.setProductInfo(productId);
			ReviewRunnable reviewRunnable = new ReviewRunnable();
			reviewRunnable.setReview(productId);

			Thread productInfoThread = new Thread(productInfoRunnable);
			Thread reviewThread = new Thread(reviewRunnable);

			productInfoThread.start();
			reviewThread.start();

			productInfoThread.join();
			reviewThread.join();

			stopWatch.stop();
			log("Total Time Taken : "+ stopWatch.getTime());
			return new Product(productId, productInfoRunnable.getProductInfo(), reviewRunnable.getReview());
		} catch (Exception e) {
			errorlog(e);
			return null;
		}
	}
}
