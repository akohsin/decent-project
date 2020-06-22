package com.kohsin.decent.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Claim {
    @Id
    private Long id;

    @Embedded
    private ClaimData claim;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Service> service;
}
