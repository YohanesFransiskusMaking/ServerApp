package com.myking.serverapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myking.serverapp.model.Region;

public interface RegionRepository extends JpaRepository<Region,Integer>  {

}
