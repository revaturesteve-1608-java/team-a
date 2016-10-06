package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Airplane;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Integer>{

}
