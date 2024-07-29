package com.dziem.populationapi.repository;

import com.dziem.populationapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
