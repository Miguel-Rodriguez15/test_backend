package com.test.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.exceptions.ResourceNotFoundException;
import com.test.demo.models.entity.Branch;
import com.test.demo.models.entity.Product;
import com.test.demo.reponses.DeleteResponse;
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

    public DeleteResponse deleteProduct(Long branchId, Long productId) {
      branchRepository.findById(branchId)
              .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
  
      Product product = productRepository.findById(productId)
              .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
  
      if (product.getBranch().getId().equals(branchId)) {
          productRepository.deleteById(productId);
          return new DeleteResponse("Product successfully deleted from branch.", branchId);
      } else {
          throw new IllegalArgumentException("Product does not belong to the specified branch");
      }
  }

  public Product updateStock(Long branchId, Long productId, int newStock) {
    branchRepository.findById(branchId)
        .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));

    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    if (product.getBranch().getId().equals(branchId)) {
        product.setStock(newStock); 
        return productRepository.save(product); 
    } else {
        throw new IllegalArgumentException("Product does not belong to the specified branch");
    }
}
}
