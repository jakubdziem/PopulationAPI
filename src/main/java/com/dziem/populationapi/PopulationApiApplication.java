package com.dziem.populationapi;

import com.dziem.populationapi.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class PopulationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PopulationApiApplication.class, args);
    }

}
