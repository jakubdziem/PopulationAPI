package com.dziem.populationapi.service;

import com.dziem.populationapi.model.Country;
import com.dziem.populationapi.model.YearAndPopulation;
import com.dziem.populationapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class DataService {
    private final CountryRepository countryRepository;


    @Transactional
    public void importData() {
        ArrayList<String> lines = new ArrayList<>();
        
        try {
            File myObj = new File("src/main/resources/data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                lines.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] headers = lines.get(4).split(",");

        for (int i = 5; i < lines.size(); i++) {
            Country country = getCountry(lines, i, headers);
            countryRepository.save(country);
        }
    }

    private static Country getCountry(ArrayList<String> lines, int i, String[] headers) {
        String[] values = lines.get(i).split(",");
        Country country = new Country();
        country.setCountryName(values[0].replace("\"", ""));

        List<YearAndPopulation> yearAndPopulations = new ArrayList<>();
        for (int j = 5; j < headers.length; j++) {
            YearAndPopulation yearAndPopulation = new YearAndPopulation();
            yearAndPopulation.setYearOfMeasurment(headers[j].replace("\"", ""));
            yearAndPopulation.setPopulation(values[j].replace("\"", ""));
            yearAndPopulation.setCountry(country);
            yearAndPopulations.add(yearAndPopulation);
        }
        Long population2022 = Long.parseLong(values[values.length-2].replace("\"", ""));
        Long population2023 = Long.parseLong(values[values.length-1].replace("\"", ""));
        Long birthRate = population2023 - population2022;
        country.setBirthRate(birthRate);
        country.setYearAndPopulations(yearAndPopulations);
        return country;
    }

}
