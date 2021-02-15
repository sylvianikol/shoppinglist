package com.exam.shoppinglist.repository;

import com.exam.shoppinglist.model.entity.Category;
import com.exam.shoppinglist.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryName name);
}
