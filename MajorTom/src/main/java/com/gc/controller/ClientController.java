package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.Flight;
import com.gc.service.DataService;

@RestController
public class ClientController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value="findFlight")
	public ResponseEntity<Flight> findFlightById(Flight flight){
		Flight newFlightInfo = dataService.findFlightById(flight.getFlightId());
		if(newFlightInfo != null){
			return new ResponseEntity<Flight>(newFlightInfo, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Flight>(newFlightInfo, HttpStatus.ACCEPTED);
		}
	}
	
}
