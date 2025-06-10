package com.abel.quiz_paesi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abel.quiz_paesi.entities.Country;

public interface CountryRepo extends JpaRepository<Country, String> {

}
