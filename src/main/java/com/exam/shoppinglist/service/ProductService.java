package com.exam.shoppinglist.service;

import com.exam.shoppinglist.model.service.ProductServiceModel;

import java.math.BigDecimal;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalPrice();
}
