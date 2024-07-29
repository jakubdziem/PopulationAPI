package com.dziem.populationapi.service;

import com.dziem.populationapi.model.CountryDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findAllCountries();

    CountryDTO findCountryByName(String countryName);

    CountryDTO findCountryByNameDistinctYear(String countryName, String year);

    List<CountryDTO> findCountriesByDistinctYear(String year);
}

