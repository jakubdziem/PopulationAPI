package com.dziem.populationapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CountryDTO {
    private String countryName;
    @JsonManagedReference
    private List<YearAndPopulation> yearAndPopulations;
    private Long birthRate;
}
