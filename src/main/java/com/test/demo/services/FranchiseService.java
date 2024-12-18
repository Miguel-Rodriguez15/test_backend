package com.test.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.exceptions.ResourceNotFoundException;
import com.test.demo.models.entity.Franchise;
import com.test.demo.repositories.FranchiseRepository;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    public Franchise addFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public Franchise updateFranchiseName(Long franchiseId, String newName) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new ResourceNotFoundException("Franchise not found"));
        franchise.setName(newName);

        return franchiseRepository.save(franchise);
    }
}
