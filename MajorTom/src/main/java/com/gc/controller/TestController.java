package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.Seat;
import com.gc.service.DataService;

@RestController
public class TestController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value="testSave")
	public String TestSave() {
		System.out.println(dataService.findAirlineByName("Air Estonia"));
		//dataService.saveFlight(new Flight());
		return "/TestPage.html";
	}
	
	@RequestMapping(value="testTicket")
	public void testTicket() {
		System.out.println("test the ticket");
		Seat s = dataService.findSeatById(1);
		System.out.println("seat:" + s);
		System.out.println("ticket:" + dataService.findTicketBySeat(s));
	}
	
	@RequestMapping(value="testSeats")
	public void testSeats() {
		List<Seat> seats = dataService.findSeatsByFlight(dataService.findFlightById(1));
		if(seats != null) {
			for (Seat s : seats) {
				System.out.println("Seat: " + s);
			}
		}
	}
}
