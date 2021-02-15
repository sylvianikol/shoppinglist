package com.exam.shoppinglist.service.impl;


import com.exam.shoppinglist.model.entity.Product;
import com.exam.shoppinglist.model.service.ProductServiceModel;
import com.exam.shoppinglist.repository.ProductRepository;
import com.exam.shoppinglist.service.CategoryService;
import com.exam.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
