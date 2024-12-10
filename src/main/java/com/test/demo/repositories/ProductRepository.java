package com.test.demo.repositories;

import org.springframework.stereotype.Repository;

import com.test.demo.models.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
  
}
