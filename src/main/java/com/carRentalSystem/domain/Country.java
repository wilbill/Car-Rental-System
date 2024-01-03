package com.carRentalSystem.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Country {
    @Id
    private String code;

    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<State>stateList = new ArrayList<>();
    @Embedded
    private AuditData auditData = new AuditData();

    @Column(name="population", nullable = false)
    private Integer population;


}
