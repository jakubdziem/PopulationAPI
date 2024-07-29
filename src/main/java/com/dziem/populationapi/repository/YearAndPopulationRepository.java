package com.dziem.populationapi.repository;

import com.dziem.populationapi.model.YearAndPopulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearAndPopulationRepository extends JpaRepository<YearAndPopulation, Long> {
}
