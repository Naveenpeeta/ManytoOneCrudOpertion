package com.manytoone.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manytoone.demo.model.CategoryModel;
import com.manytoone.demo.service.CategoryJpaService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
//@RequestMapping("/cat")
public class CategoryController {
     @Autowired
     private CategoryJpaService categoryJpaService;
     
     @GetMapping("/categories")
     public ArrayList<CategoryModel> getCategories() {
         return categoryJpaService.getCategories();
     }
     
     @GetMapping("/categories/{categoryId}")
     public CategoryModel getCategoryById(@PathVariable int categoryId) {
    	 return categoryJpaService.getCategoryById(categoryId);
     }
     @PutMapping("/categories/{categoryId}")
     public CategoryModel updateCategory(@PathVariable ("categoryId") int catrgoryId, @RequestBody CategoryModel  category) {
         return categoryJpaService.updateCategory(category, catrgoryId);
     }
     @PostMapping("/categories")
     public CategoryModel addCategory(@RequestBody CategoryModel category) {
    	 return categoryJpaService.addCategory(category);
     }
     @DeleteMapping("categories/{categoryId}")
    	 public void deleteCategory(@PathVariable int categoryId) {
    		 categoryJpaService.deleteCategory(categoryId);
    	 }
     
      
     
}
