package com.manytoone.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class ProductModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(name="name")
   private String name;
   @Column(name = "description")
   private String description;
   @Column(name = "price")
   private Double price;
   @ManyToOne
   @JoinColumn(name="categoryId")
   private CategoryModel categoryModel;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public CategoryModel getCategoryModel() {
	return categoryModel;
}
public void setCategoryModel(CategoryModel categoryModel) {
	this.categoryModel = categoryModel;
}
   
   
   
   
   
}
