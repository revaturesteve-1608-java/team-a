package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.Flight;
import com.gc.service.DataService;

@RestController
public class ClientController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping("/findFlight/{flightId}")
	public ResponseEntity<Flight> findFlightById(@PathVariable(value="flightId") Integer flightId){
		System.out.println("flightId: " + flightId);
		Flight newFlightInfo = dataService.findFlightById(flightId);
		System.out.println(newFlightInfo);
		if(newFlightInfo != null){
			return new ResponseEntity<Flight>(newFlightInfo, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Flight>(newFlightInfo, HttpStatus.I_AM_A_TEAPOT);
		}
	}
	
}
