package com.kohsin.decent.service;

import com.kohsin.decent.entities.Claim;

import java.util.List;
import java.util.Optional;

public interface ClaimDataProvider {
    List<Claim> findAll();
    Optional<Claim> findById(Long var1);
    List<Claim> findByClaim_InsuredID(String insuredId);
}
