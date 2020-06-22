package com.kohsin.decent.service;

import com.kohsin.decent.dto.ClaimResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimService {

    private ClaimDataProvider claimDataProvider;


    public ClaimService(ClaimDataProvider claimRepository) {
        this.claimDataProvider = claimRepository;
    }

    public List<ClaimResponseDto> getAll() {
        return claimDataProvider.findAll().stream().map(ClaimResponseDto::new).collect(Collectors.toList());
    }

    public List<ClaimResponseDto> getByInsuredId(String insuredId) {
        return claimDataProvider.findByClaim_InsuredID(insuredId).stream().map(ClaimResponseDto::new).collect(Collectors.toList());
    }

    public ClaimResponseDto getById(Long claimId) {
        return claimDataProvider.findById(claimId).map(ClaimResponseDto::new).orElse(null);
    }
}
