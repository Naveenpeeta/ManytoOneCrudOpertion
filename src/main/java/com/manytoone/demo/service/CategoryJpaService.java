package com.manytoone.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.manytoone.demo.model.CategoryModel;
import com.manytoone.demo.repository.CategoryJpaRepository;
import com.manytoone.demo.repository.CategoryRepository;

@Service

public class CategoryJpaService implements CategoryRepository {
	@Autowired
	private CategoryJpaRepository categoryJpaRepository;
	
	//@override
	
	public ArrayList<CategoryModel> getCategories(){
		List<CategoryModel> categoryList = categoryJpaRepository.findAll();
		ArrayList<CategoryModel> category = new ArrayList<>(categoryList);
		return category;
		
	}

	@Override
	public CategoryModel getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		try {
			CategoryModel category = categoryJpaRepository.findById(categoryId).get();
			return category;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public CategoryModel addCategory(CategoryModel category) {
		// TODO Auto-generated method stub
		categoryJpaRepository.save(category);
		return category;
	}

	@Override
	public CategoryModel updateCategory(CategoryModel category, int categoryId) {
		CategoryModel newCategory = categoryJpaRepository.findById(categoryId).get();
		if(category.getName()!=null) {
			newCategory.setName(category.getName());
		}
		if(category.getDescription()!=null) {
			newCategory.setDescription(category.getDescription());
		}
		categoryJpaRepository.save(newCategory);
		return newCategory;
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryJpaRepository.deleteById(categoryId);
		
	}
}
