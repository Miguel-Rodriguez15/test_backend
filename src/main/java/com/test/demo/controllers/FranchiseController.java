package com.test.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.models.entity.Franchise;
import com.test.demo.models.entity.Product;
import com.test.demo.services.FranchiseService;
import com.test.demo.services.ProductService;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise) {
        Franchise newFranchise = franchiseService.addFranchise(franchise);
        return new ResponseEntity<>(newFranchise, HttpStatus.CREATED);
    }

    @GetMapping("/{franchiseId}/products/max-stock")
    public ResponseEntity<List<Product>> getMaxStockProductsByFranchise(@PathVariable Long franchiseId) {
        List<Product> products = productService.getMaxStockProductsByFranchise(franchiseId);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{franchiseId}/name")
    public ResponseEntity<Franchise> updateFranchiseName(@PathVariable Long franchiseId, @RequestBody String newName) {
        Franchise updatedFranchise = franchiseService.updateFranchiseName(franchiseId, newName);
        return ResponseEntity.ok(updatedFranchise);
    }
}