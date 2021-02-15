package com.exam.shoppinglist.service.impl;

import com.exam.shoppinglist.model.entity.Category;
import com.exam.shoppinglist.model.entity.CategoryName;
import com.exam.shoppinglist.repository.CategoryRepository;
import com.exam.shoppinglist.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {

            Arrays.stream(CategoryName.values())
                    .forEach(value -> {
                        Category category = new Category();
                        category.setName(value);
                        category.setDescription("Description of " + value.name());

                        this.categoryRepository.save(category);
                    });
        }
    }
}
