package com.manytoone.demo.repository;

import java.util.ArrayList;

import com.manytoone.demo.model.CategoryModel;
import com.manytoone.demo.model.ProductModel;

public interface ProductRepository {
	 ArrayList<ProductModel> getProducts();
	 ProductModel getProductById(int productId);
	 ProductModel addProduct(ProductModel product);
	 ProductModel updateProduct(int productId, ProductModel product);
	 void deleteProduct(int productId);
	 CategoryModel getProductCategory(int productId);
}
