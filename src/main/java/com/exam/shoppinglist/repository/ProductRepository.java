package com.exam.shoppinglist.repository;

import com.exam.shoppinglist.model.entity.CategoryName;
import com.exam.shoppinglist.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT sum(p.price) FROM Product p ")
    BigDecimal getTotalPrice();

    List<Product> findAllByCategory_Name(CategoryName name);
}
