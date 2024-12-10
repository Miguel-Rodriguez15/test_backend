package com.test.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.models.entity.Branch;
import com.test.demo.services.BranchService;

@RestController
@RequestMapping("/franchises/{franchiseId}/branches")
public class BranchController {
  
   @Autowired
    private BranchService branchService;

        @PostMapping
    public ResponseEntity<Branch> addBranch(@PathVariable Long franchiseId, @RequestBody Branch branch) {
      Branch newBranch = branchService.addBranch(franchiseId, branch);
        return new ResponseEntity<>(newBranch, HttpStatus.CREATED);
    }

    @PutMapping("/{branchId}/name")
    public ResponseEntity<Branch> updateBranchName(@PathVariable Long branchId, @RequestBody String newName) {
      Branch updatedBranch = branchService.updateBranchName(branchId, newName);
      return ResponseEntity.ok(updatedBranch);
    }
}
