package com.exam.shoppinglist.service;

import com.exam.shoppinglist.model.entity.Category;
import com.exam.shoppinglist.model.entity.CategoryName;

public interface CategoryService {

    void initCategories();

    Category findByName(CategoryName name);
}
