package com.dziem.populationapi.mapper;
import com.dziem.populationapi.model.YearAndPopulation;
import com.dziem.populationapi.model.YearAndPopulationDTO;
import org.mapstruct.Mapper;
@Mapper
public interface YearAndPopulationMapper {
    YearAndPopulation yearAndPopulationDtoToYearAndPopulation(YearAndPopulationDTO dto);
    YearAndPopulationDTO yearAndPopulationToYearAndPopulationDto(YearAndPopulation yearAndPopulation);
}
