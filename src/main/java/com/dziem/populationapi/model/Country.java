package com.dziem.populationapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Country {
    @Id
    private String countryName;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<YearAndPopulation> yearAndPopulations;
    private Long birthRate;
}
