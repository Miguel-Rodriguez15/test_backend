package com.test.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.models.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long>{
  
}
