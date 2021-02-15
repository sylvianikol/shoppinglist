package com.exam.shoppinglist.service.impl;


import com.exam.shoppinglist.model.entity.CategoryName;
import com.exam.shoppinglist.model.entity.Product;
import com.exam.shoppinglist.model.service.ProductServiceModel;
import com.exam.shoppinglist.model.view.ProductViewModel;
import com.exam.shoppinglist.repository.ProductRepository;
import com.exam.shoppinglist.service.CategoryService;
import com.exam.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        product.setCategory(this.categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);

    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.productRepository.getTotalPrice();
    }

    @Override
    public List<ProductServiceModel> getAllByCategoryName(CategoryName categoryName) {
        return this.productRepository.findAllByCategory_Name(categoryName).stream()
                .map(p -> this.modelMapper.map(p, ProductServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }
}
