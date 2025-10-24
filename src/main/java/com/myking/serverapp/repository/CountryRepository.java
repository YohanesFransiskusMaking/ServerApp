package com.myking.serverapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myking.serverapp.model.Country;

public interface CountryRepository extends JpaRepository <Country, Integer> {

}
