package com.exam.shoppinglist.service;

import com.exam.shoppinglist.model.entity.CategoryName;
import com.exam.shoppinglist.model.service.ProductServiceModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    boolean add(ProductServiceModel productServiceModel);

    BigDecimal getTotalPrice();

    List<ProductServiceModel> getAllByCategoryName(CategoryName categoryName);

    void buyById(Long id);

    void buyAll();
}
