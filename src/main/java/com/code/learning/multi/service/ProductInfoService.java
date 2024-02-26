package com.code.learning.multi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.learning.multi.model.ProductInfo;
import com.code.learning.multi.model.ProductOption;
import static com.code.learning.multi.util.LoggerUtil.*;
import static com.code.learning.multi.util.CommonUtil.*;

@Service
public class ProductInfoService {

    public ProductInfo retrieveProductInfo(String productId) {
    	delay(1000);
        List<ProductOption> productOptions = List.of(new ProductOption(1, "64GB", "Black", 699.99),
                new ProductOption(2, "128GB", "Black", 749.99));
        log("retrieveProductInfo after Delay");
        return ProductInfo.builder().productId(productId)
                .productOptions(productOptions)
                .build();
    }
}
