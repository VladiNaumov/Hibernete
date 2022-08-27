package com.naumdeveloper.homework.version1;

import com.naumdeveloper.homework.version1.model.Product;

import java.util.List;

public interface ProductDaoInterface {

    Product findById(Long id);
    Product findByName(String name);
    List<Product> findAll();
    void save(Product product);
    void updateNameById(Long id, String newName);
    void testCaching();
}
