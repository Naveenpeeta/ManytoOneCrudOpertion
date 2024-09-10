package com.manytoone.demo.repository;

import java.util.ArrayList;

import com.manytoone.demo.model.CategoryModel;

public interface CategoryRepository {
    ArrayList<CategoryModel> getCategories();
    CategoryModel getCategoryById(int categoryId);
    CategoryModel addCategory(CategoryModel category);
    CategoryModel updateCategory(CategoryModel category, int categoryId);
    void deleteCategory(int categoryId);
}
