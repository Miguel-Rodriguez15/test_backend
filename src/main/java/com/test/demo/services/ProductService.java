package com.test.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.exceptions.ResourceNotFoundException;
import com.test.demo.models.entity.Branch;
import com.test.demo.models.entity.Product;
import com.test.demo.repositories.BranchRepository;
import com.test.demo.repositories.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private BranchRepository branchRepository;

   public Product addProduct(Long branchId, Product product) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));

        product.setBranches(branch);
        return productRepository.save(product);
    }
}
