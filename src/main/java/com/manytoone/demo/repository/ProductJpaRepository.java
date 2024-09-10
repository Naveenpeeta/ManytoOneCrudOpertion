package com.manytoone.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytoone.demo.model.ProductModel;

public interface ProductJpaRepository extends JpaRepository<ProductModel, Integer> {

}
