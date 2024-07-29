package com.dziem.populationapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class YearAndPopulationDTO {
    private Long id;
    private String yearOfMeasurment;
    private String population;

    @JsonBackReference
    private Country country;
}
