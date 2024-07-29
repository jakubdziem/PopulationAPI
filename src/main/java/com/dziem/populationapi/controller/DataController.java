package com.dziem.populationapi.controller;

import com.dziem.populationapi.model.CountryDTO;
import com.dziem.populationapi.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class DataController {
    private final CountryService countryService;

    @GetMapping("/api/v1/country/all/all")
    public List<CountryDTO> getCountries() {
        return countryService.findAllCountries();
    }
    @GetMapping("/api/v1/country/all/{countryName}")
    public ResponseEntity<CountryDTO> getCountryByName(@PathVariable("countryName") String countryName){

        CountryDTO countryDTO = countryService.findCountryByName(countryName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/country/all/" + countryName);

        return new ResponseEntity<>(countryDTO, headers, HttpStatus.OK);
    }
    @GetMapping("/api/v1/country/{year}/{countryName}")
    public ResponseEntity<CountryDTO> getCountryByNameDistinctYear(@PathVariable("countryName") String countryName, @PathVariable("year") String year) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/country/" + year + "/" + countryName);
        CountryDTO countryDTO = countryService.findCountryByNameDistinctYear(countryName, year);

        return new ResponseEntity<>(countryDTO, headers, HttpStatus.OK);
    }
    @GetMapping("/api/v1/country/{year}/all")
    public ResponseEntity<List<CountryDTO>> getCountriesByDistinctYear(@PathVariable("year") String year) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/country/" + year + "/all");
        List<CountryDTO> countryDTOList = countryService.findCountriesByDistinctYear(year);

        return new ResponseEntity<>(countryDTOList, headers, HttpStatus.OK);
    }
}
