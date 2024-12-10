package com.test.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.models.entity.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
}
