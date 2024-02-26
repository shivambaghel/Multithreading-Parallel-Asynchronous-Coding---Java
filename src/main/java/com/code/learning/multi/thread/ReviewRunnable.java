package com.code.learning.multi.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.code.learning.multi.model.Review;
import com.code.learning.multi.service.ReviewService;

@Component
public class ReviewRunnable implements Runnable {

	@Autowired
	private ReviewService reviewService;

	private String productId;
	private Review review;

	public void setReview(String productId) {
		this.productId = productId;
	}
	public Review getReview() {
		return review;
	}

	//runnable dosen't take/return any value so we need to use additional methods to utilize its behavior
	//as its an interface, we need to implement its method
	@Override
	public void run() {
		review = reviewService.retrieveReviews(productId);
	}
}