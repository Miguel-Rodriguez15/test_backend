package com.test.demo.repositories;

import org.springframework.stereotype.Repository;

import com.test.demo.models.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
 
  @Query("SELECT p FROM Product p WHERE p.branch.id = :branchId AND p.stock = (SELECT MAX(p2.stock) FROM Product p2 WHERE p2.branch.id = :branchId)")
  List<Product> findAllWithMaxStockByBranchId(@Param("branchId") Long branchId);
}