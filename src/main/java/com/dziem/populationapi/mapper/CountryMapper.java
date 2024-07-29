package com.dziem.populationapi.mapper;

import com.dziem.populationapi.model.Country;
import com.dziem.populationapi.model.CountryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country countryDtoToCountry(CountryDTO dto);
    CountryDTO countryToCountryDto(Country country);
}
