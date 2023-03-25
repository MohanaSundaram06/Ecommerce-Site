package com.ecommerce.shopping.dao;

import com.ecommerce.shopping.entity.Category;

import java.util.List;

public interface CategoryDAO {

    boolean addCategory(Category theCategory);

    boolean deleteCategory(Category theCategory);

    boolean updateCategory(Category theCategory);

    List<Category> categoryList();

    Category getCategory(int id);

}


















