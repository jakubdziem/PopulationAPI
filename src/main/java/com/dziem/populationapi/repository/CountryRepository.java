package com.dziem.populationapi.repository;

import com.dziem.populationapi.model.Country;
import com.dziem.populationapi.model.CountryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
