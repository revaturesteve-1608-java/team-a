package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.SeatType;

@Repository
public interface SeatTypeRepo extends JpaRepository<SeatType, Integer> {

}
