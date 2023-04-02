package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.Category;

import java.util.List;

public interface CategoryService {

    boolean addCategory(Category theCategory);

    boolean deleteCategory(Category theCategory);

    boolean updateCategory(Category theCategory);

    List<Category> categoryList();

    Category getCategory(int id);
}
