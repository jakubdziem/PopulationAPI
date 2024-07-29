package com.dziem.populationapi.service;

import com.dziem.populationapi.model.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<CountryDTO> findAllCountries();

    public CountryDTO findCountryByName(String countryName);

    CountryDTO findCountryByNameDistinctYear(String countryName, String year);

    List<CountryDTO> findCountriesByDistinctYear(String year);
}

