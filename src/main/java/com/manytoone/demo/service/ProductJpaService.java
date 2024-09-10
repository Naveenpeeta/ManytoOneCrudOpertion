package com.manytoone.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.manytoone.demo.model.CategoryModel;
import com.manytoone.demo.model.ProductModel;
import com.manytoone.demo.repository.ProductJpaRepository;
import com.manytoone.demo.repository.ProductRepository;

@Service
public class ProductJpaService implements ProductRepository{
    @Autowired 
    private CategoryJpaService categoryJpaservice;
	
	@Autowired 
    ProductJpaRepository productJpaRepository;

	@Override
	public ArrayList<ProductModel> getProducts() {
		List<ProductModel> product = productJpaRepository.findAll();
		ArrayList<ProductModel> products = new ArrayList<>(product);
		return products;
	}

	@Override
	public ProductModel getProductById(int productId) {
		try {
			ProductModel product = productJpaRepository.findById(productId).get();
			return product;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ProductModel addProduct(ProductModel product) {
		 int categoryId = product.getCategoryModel().getId();

	        CategoryModel category = categoryJpaservice.getCategoryById(categoryId);
	        product.setCategoryModel(category);

	        productJpaRepository.save(product);
	        return product;
		
	}

	@Override
	public ProductModel updateProduct(int productId, ProductModel product) {
		try {
		ProductModel newProduct = productJpaRepository.findById(productId).get();
		if(product.getCategoryModel() !=null) {
			int categoryId = product.getCategoryModel().getId();
			CategoryModel newCategory = categoryJpaservice.getCategoryById(categoryId);
			newProduct.setCategoryModel(newCategory);
		}
		if(product.getName() !=null) {
			newProduct.setName(product.getName());
		}
		if(product.getDescription() !=null) {
			newProduct.setDescription(product.getDescription());
		}
		if(product.getPrice()!=null) {
			newProduct.setPrice(product.getPrice());
		}
		return productJpaRepository.save(newProduct);
		}catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
		
	}

	@Override
	public void deleteProduct(int productId) {
		try {
			productJpaRepository.deleteById(productId);
		}catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

		
	}

	@Override
	public CategoryModel getProductCategory(int productId) {
         try {
        	 ProductModel product = productJpaRepository.findById(productId).get();
        	 CategoryModel category = product.getCategoryModel();
        	 return category;
        	 
         }catch (Exception e) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         }
		
	}
    
}
