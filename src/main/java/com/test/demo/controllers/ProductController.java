package com.test.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.models.entity.Product;
import com.test.demo.reponses.DeleteResponse;
import com.test.demo.services.ProductService;

@RestController
@RequestMapping("/branches/{branchId}/products")
public class ProductController {
   @Autowired
    private ProductService  productService;

     @PostMapping
    public ResponseEntity<Product> addProduct(@PathVariable Long branchId, @RequestBody Product product) {
        Product newProduct = productService.addProduct(branchId, product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<DeleteResponse> deleteProduct(@PathVariable Long branchId, @PathVariable Long productId) {
        DeleteResponse response = productService.deleteProduct(branchId, productId);
        return ResponseEntity.ok(response);
    }

        @PutMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long branchId, @PathVariable Long productId, @RequestBody int newStock) {
        Product updatedProduct = productService.updateStock(branchId, productId, newStock);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/{productId}/name")
    public ResponseEntity<Product> updateProductName(
            @PathVariable Long branchId,
            @PathVariable Long productId,
            @RequestBody String newName) {
        Product updatedProduct = productService.updateProductName(productId, newName);
        return ResponseEntity.ok(updatedProduct);
    }
}
