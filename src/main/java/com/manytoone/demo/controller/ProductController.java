package com.manytoone.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manytoone.demo.model.CategoryModel;
import com.manytoone.demo.model.ProductModel;
import com.manytoone.demo.service.ProductJpaService;

@RestController
public class ProductController {
	@Autowired
    private ProductJpaService productJpaService;
    
	 @GetMapping("/categories/products")
    public ArrayList<ProductModel> getProduct() {
        return productJpaService.getProducts();
    }
    
	 @GetMapping("/categories/products/{productId}")
    public ProductModel getCategoryById(@PathVariable int productId) {
   	 return productJpaService.getProductById(productId);
    }
	 @PutMapping("/categories/products/{productId}")
    public ProductModel updateProduct(@PathVariable int productId, @RequestBody ProductModel  product) {
        return productJpaService.updateProduct(productId, product);
    }
	 @PostMapping("/categories/products")
    public ProductModel addProduct(@RequestBody ProductModel product) {
   	 return productJpaService.addProduct(product);
    }
	 @DeleteMapping("/categories/products/{productId}")
   	 public void deleteProduct(@PathVariable int productId) {
   		productJpaService.deleteProduct(productId);
   	 }
    @GetMapping("/products/{productId}/category")
    public CategoryModel getProductCategory(@PathVariable int productId) {
        return productJpaService.getProductCategory(productId);
    }
}
