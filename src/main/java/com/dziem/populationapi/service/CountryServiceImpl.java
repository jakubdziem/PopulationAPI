package com.dziem.populationapi.service;

import com.dziem.populationapi.exception.NotFoundException;
import com.dziem.populationapi.mapper.CountryMapper;
import com.dziem.populationapi.model.Country;
import com.dziem.populationapi.model.CountryDTO;
import com.dziem.populationapi.model.YearAndPopulation;
import com.dziem.populationapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    @Override
    public List<CountryDTO> findAllCountries() {
        List<Country> all = countryRepository.findAll();
        List<CountryDTO> countries = new ArrayList<>();
        for(Country country : all) {
            CountryDTO countryDTO = countryMapper.countryToCountryDto(country);
            countries.add(countryDTO);
        }
        return countries;
    }

    @Override
    public CountryDTO findCountryByName(String countryName) {
        Country country = countryRepository.findById(countryName).orElseThrow(NotFoundException::new);
        return countryMapper.countryToCountryDto(country);
    }

    @Override
    public CountryDTO findCountryByNameDistinctYear(String countryName, String year) {
        Country country = countryRepository.findById(countryName).orElseThrow(NotFoundException::new);
        int yearNum = Integer.parseInt(year);
        if(yearNum >= 1960 && yearNum <= 2023) {
            YearAndPopulation yearAndPopulation = country.getYearAndPopulations().get(yearNum - 1960);
            List<YearAndPopulation> yearAndPopulationList = new ArrayList<>();
            yearAndPopulationList.add(yearAndPopulation);
            country.setYearAndPopulations(yearAndPopulationList);
        } else {
            throw new NotFoundException("Year must be between 1960 to 2023");
        }
        return countryMapper.countryToCountryDto(country);
    }

    @Override
    public List<CountryDTO> findCountriesByDistinctYear(String year) {
        List<Country> all = countryRepository.findAll();
        int yearNum = Integer.parseInt(year);
        List<CountryDTO> countries = new ArrayList<>();
        if(yearNum >= 1960 && yearNum <= 2023) {
            for(Country country : all) {
                YearAndPopulation yearAndPopulation = country.getYearAndPopulations().get(yearNum - 1960);
                List<YearAndPopulation> yearAndPopulationList = new ArrayList<>();
                yearAndPopulationList.add(yearAndPopulation);
                country.setYearAndPopulations(yearAndPopulationList);

                CountryDTO countryDTO = countryMapper.countryToCountryDto(country);
                countries.add(countryDTO);
            }
        } else {
            throw new NotFoundException("Year must be between 1960 to 2023");
        }
        return countries;
    }
}
