package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.Flight;
import com.gc.model.Seat;
import com.gc.model.Ticket;
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
	
	@RequestMapping(value="findTicketBySeat")
	public ResponseEntity<Ticket> findTicketBySeat(Seat seat) {
		Ticket ticket = dataService.findTicketBySeat(seat);
		if(ticket != null) {
			System.out.println("Ticket: " + ticket);
			return new ResponseEntity<Ticket>(ticket, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Ticket>(ticket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="findSeatsByFlight")
	public ResponseEntity<List<Seat>> findSeatsByFlight(Flight flight) {
		List<Seat> seats = dataService.findSeatsByFlight(flight);
		if(seats != null) {
			for (Seat s : seats) {
				System.out.println("Seat: " + s);
			}
			return new ResponseEntity<List<Seat>>(seats, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<List<Seat>>(seats, HttpStatus.BAD_REQUEST);
		}
	}
	
}
