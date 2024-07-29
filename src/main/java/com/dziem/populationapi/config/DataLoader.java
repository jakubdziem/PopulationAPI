package com.dziem.populationapi.config;

import com.dziem.populationapi.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final DataService dataService;
    @Override
    public void run(String... args) throws Exception {
        dataService.importData();
    }
}
