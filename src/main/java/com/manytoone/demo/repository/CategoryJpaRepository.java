 package com.manytoone.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytoone.demo.model.CategoryModel;

public interface CategoryJpaRepository extends JpaRepository<CategoryModel, Integer> {

}
