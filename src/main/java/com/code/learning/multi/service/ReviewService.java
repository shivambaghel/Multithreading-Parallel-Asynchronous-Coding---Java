package com.code.learning.multi.service;

import org.springframework.stereotype.Service;

import com.code.learning.multi.model.Review;
import static com.code.learning.multi.util.LoggerUtil.*;
import static com.code.learning.multi.util.CommonUtil.*;

@Service
public class ReviewService {

	public Review retrieveReviews(String productId) {
		delay(1000);
		log("retrieveReviews after Delay");
		return new Review(200, 4.5);
	}
}