package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Destination;

@Repository
public interface DestinationRepo extends JpaRepository<Destination, Integer> {

}
