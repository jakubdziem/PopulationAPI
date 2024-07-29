package com.dziem.populationapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Data
public class CountryDTO {
    private String countryName;
    @JsonManagedReference
    private List<YearAndPopulation> yearAndPopulations;
    private Long birthRate;
}
