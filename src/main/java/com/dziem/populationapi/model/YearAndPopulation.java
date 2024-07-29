package com.dziem.populationapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class YearAndPopulation {
    @Id
    @GeneratedValue
    private Long id;
    private String yearOfMeasurment;
    private String population;

    @ManyToOne
    @JoinColumn(name = "country_name", referencedColumnName = "countryName")
    @JsonBackReference
    private Country country;
}
