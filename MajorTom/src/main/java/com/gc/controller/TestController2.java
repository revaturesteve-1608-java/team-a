package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.Airplane;
import com.gc.model.Flight;
import com.gc.model.SeatType;
import com.gc.service.DataService;

@RestController
public class TestController2 {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value="testCreateSeats")
	public String TestSave() {
		Airplane airplane = new Airplane("Boeing 737-800");
		//dataService.saveAirplane(airplane);
		
		Flight flight = new Flight(dataService.findDestinationById(1), dataService.findAirlineById(3), airplane);
		flight.setFlightId(1402);
		//dataService.saveFlight(flight);
		
		List<SeatType> seatTypes = dataService.findAllSeatTypes();
		System.out.println(seatTypes);
		
		return "/index.html";
	}

}
