package com.kohsin.decent.repository;

import com.kohsin.decent.entities.Claim;
import com.kohsin.decent.service.ClaimDataProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>, ClaimDataProvider {

    List<Claim> findByClaim_InsuredID(String insuredId);
}
