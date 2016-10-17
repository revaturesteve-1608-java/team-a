package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gc.model.Flight;
import com.gc.model.Seat;
import com.gc.model.SeatType;
import com.gc.service.DataService;

@Controller
public class TestController2 {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value="testCreateSeats")
	public String TestSave() {
//		dataService.saveAirplane(new Airplane("Boeing 737-200"));
//		Airplane airplane = dataService.findAirplaneByName("Boeing 737-200");
		
//		dataService.saveFlight(new Flight(dataService.findDestinationById(5), dataService.findAirlineById(5), airplane));
		Flight flight = dataService.findFlightById(3283);
		
		List<SeatType> seatTypes = dataService.findAllSeatTypes();
		
//		SeatType first = null;
//		SeatType buisness = null;
		SeatType economy = null;
		
		for (SeatType type : seatTypes) {
//			if (type.getSeatTypeId() == 3)
//				first = type;
//
//			if (type.getSeatTypeId() == 2)
//				buisness = type;

			if (type.getSeatTypeId() == 1)
				economy = type;
		}
		
//		for (int i = 0; i < 4; i++){
//			dataService.saveSeat(new Seat(first, flight));
//		}
//		for (int i = 0; i < 12; i++){
//			dataService.saveSeat(new Seat(buisness, flight));
//		}
		for (int i = 0; i < 6; i++){
			dataService.saveSeat(new Seat(economy, flight));
		}
		
		return "/index.html";
	}

}
