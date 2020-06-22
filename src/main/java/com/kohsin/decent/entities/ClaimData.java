package com.kohsin.decent.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class ClaimData {

    private String submitDate;
    private String insuredFirst;
    private String insuredLast;
    private String insuredID;
}
