package com.kohsin.decent.dto;

import com.kohsin.decent.entities.Claim;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class ClaimResponseDto {

    private Long id;
    private String submitDate;
    private String insuredFirst;
    private String insuredLast;
    private String insuredId;

    private List<ServiceDto> serviceDtoList;

    public ClaimResponseDto(Claim claim) {
        this.id = claim.getId();
        this.submitDate = claim.getClaim().getSubmitDate();
        this.insuredFirst = claim.getClaim().getInsuredFirst();
        this.insuredLast = claim.getClaim().getInsuredLast();
        this.insuredId = claim.getClaim().getInsuredID();
        this.serviceDtoList = claim.getService().stream().map(ServiceDto::new).collect(Collectors.toList());
    }
}
