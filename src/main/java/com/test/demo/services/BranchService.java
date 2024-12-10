package com.test.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.exceptions.ResourceNotFoundException;
import com.test.demo.models.entity.Branch;
import com.test.demo.models.entity.Franchise;
import com.test.demo.repositories.BranchRepository;
import com.test.demo.repositories.FranchiseRepository;

@Service
public class BranchService {
   @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private FranchiseRepository franchiseRepository;

    public Branch addBranch(Long franchiseId, Branch branch) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new ResourceNotFoundException("Franchise not found"));

        branch.setFranchise(franchise);
        return branchRepository.save(branch);
    }

    public Branch updateBranchName(Long branchId, String newName) {
      Branch branch = branchRepository.findById(branchId)
          .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
      branch.setName(newName);
      return branchRepository.save(branch);
    }
}
