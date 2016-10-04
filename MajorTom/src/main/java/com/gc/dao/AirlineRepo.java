package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Airline;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer>{

}
