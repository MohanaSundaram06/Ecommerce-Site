package com.ecommerce.shopping.service;

import com.ecommerce.shopping.dao.CategoryDAO;
import com.ecommerce.shopping.entity.Category;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO theCategoryDAO;

    @Override
    @Transactional
    public boolean addCategory(Category theCategory) {

        return theCategoryDAO.addCategory(theCategory);
    }

    @Override
    @Transactional
    public boolean deleteCategory(Category theCategory) {

        return theCategoryDAO.deleteCategory(theCategory);
    }

    @Override
    @Transactional
    public boolean updateCategory(Category theCategory) {

        return theCategoryDAO.updateCategory(theCategory);
    }

    @Override
    @Transactional
    public List<Category> categoryList() {

        return theCategoryDAO.categoryList();
    }

    @Override
    @Transactional
    public Category getCategory(int id) {

        return theCategoryDAO.getCategory(id);
    }
}
