package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/findFlightByTicket/{ticketId}")
	public ResponseEntity<Flight> findFlightByTicket(@PathVariable(value="ticketId") Integer ticketId){
		try
		{
			Ticket tick = dataService.findTicketById(ticketId);
			Seat seat = tick.getSeat();
			Flight flight = seat.getFlight();
			if(flight==null){throw new NullPointerException();}
			return new ResponseEntity<Flight>(flight,HttpStatus.OK);
		}
		catch(NullPointerException e)
		{
			return new ResponseEntity<Flight>((Flight)null,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/findTicketBySeat/{seatId}")
	public ResponseEntity<Ticket> findTicketBySeat(@PathVariable(value="seatId") Integer seatId) {
		Ticket ticket = dataService.findTicketBySeat(dataService.findSeatById(seatId));
		if(ticket != null) {
			System.out.println("Ticket: " + ticket);
			return new ResponseEntity<Ticket>(ticket, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Ticket>(ticket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/findSeatsByFlight/{flightId}")
	public ResponseEntity<List<Seat>> findSeatsByFlight(@PathVariable(value="flightId") Integer flightId) {
		List<Seat> seats = dataService.findSeatsByFlight(dataService.findFlightById(flightId));
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
