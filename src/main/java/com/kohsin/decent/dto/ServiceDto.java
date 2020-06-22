package com.kohsin.decent.dto;

import com.kohsin.decent.entities.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
class ServiceDto {
    private Long id;
    private Integer lineNumber;
    private Integer lineCharge;
    private String svcFromDate;
    private String svcToDate;

    public ServiceDto(Service service) {
        this.id = service.getId();
        this.lineNumber = service.getLineNumber();
        this.lineCharge = service.getLineCharge();
        this.svcFromDate = service.getSvcFromDate();
        this.svcToDate = service.getSvcToDate();
    }
}
