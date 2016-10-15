package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dto.AuthenticationDTO;
import com.gc.dto.ReassignSeatDTO;
import com.gc.dto.SetSeatDTO;
import com.gc.model.Employee;
import com.gc.model.Flight;
import com.gc.model.Seat;
import com.gc.model.Ticket;
import com.gc.service.DataService;


@RestController
public class ClientController {

	@Autowired
	DataService dataService;
	
	Employee emp;
	

	@RequestMapping("/findFlight/{flightId}")
	public ResponseEntity<Flight> findFlightById(@PathVariable(value = "flightId") Integer flightId) {
		Flight newFlightInfo = dataService.findFlightById(flightId);
		if (newFlightInfo != null) {
			return new ResponseEntity<>(newFlightInfo, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(newFlightInfo, HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping("/findAllFlights")
	public ResponseEntity<List<Flight>> findAllFlights() {
		List<Flight> list = dataService.findAllFlights();
		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping("/findTicket/{ticketId}")
	public ResponseEntity<Ticket> findTicket(@PathVariable(value = "ticketId") Integer ticketId){
		Ticket tick=dataService.findTicketById(ticketId);
		return new ResponseEntity<>(tick,tick==null?HttpStatus.NOT_FOUND:HttpStatus.ACCEPTED);
	}
	

	@RequestMapping(value = "/findTicketBySeat/{seatId}")
	public ResponseEntity<Ticket> findTicketBySeat(@PathVariable(value = "seatId") Integer seatId) {
		Ticket ticket = dataService.findSeatById(seatId).getTicket();
		if (ticket != null) {
			return new ResponseEntity<>(ticket, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(ticket, HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping(value = "/findSeatsByFlight/{flightId}")
	public ResponseEntity<List<Seat>> findSeatsByFlight(@PathVariable(value = "flightId") Integer flightId) {
		List<Seat> seats = dataService.findSeatsByFlight(dataService.findFlightById(flightId));
		if (seats != null) {
			return new ResponseEntity<>(seats, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(seats, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/authenticate")
	public ResponseEntity<Employee> authenticate(Model model, @RequestBody AuthenticationDTO data) {
		emp = dataService.findEmployeeByUsernameAndPassword(data.getUsername(), data.getPassword());
		if(emp != null) {
			int token = (int) (Math.random()*100000);
			emp.setToken(token);
			return new ResponseEntity<>(emp, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(emp, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value="/setSeat")
	public ResponseEntity<Seat> setSeat(@RequestBody SetSeatDTO data) {
		Ticket ticket = dataService.findTicketById(data.getTicketId());
		Seat seat = dataService.findSeatById(data.getSeatId());
		if (ticket != null && seat != null) {
			seat.setTicket(ticket);
			dataService.saveSeat(seat);
			return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(seat, HttpStatus.BAD_REQUEST);
		}
	}
	

	@RequestMapping(value="/reassignSeat")
	public ResponseEntity<Seat> reassignSeat(Model model, @RequestBody ReassignSeatDTO data) {
		Ticket ticket = dataService.findTicketById(data.getTicketId());
		Seat seat = dataService.findSeatById(data.getSeatId());
		Seat seat2 = dataService.findSeatById(data.getSeat2Id());
		if (ticket == null && data.getLoginToken() == emp.getToken()){
			if(seat != null){
				if(seat2 != null){
					Ticket tempTicket = seat.getTicket();
					seat.setTicket(seat2.getTicket());
					seat2.setTicket(tempTicket);
					dataService.saveSeat(seat);
					dataService.saveSeat(seat2);
					return reassignSeatAndEmail(seat);
				} else {
					seat.setTicket(null);
					dataService.saveSeat(seat);
					dataService.saveSeat(seat2);
					return reassignSeatAndEmail(seat);
				}
			} else {
				if(seat2.getTicket() != null){
					seat2.setTicket(null);
					dataService.saveSeat(seat);
					dataService.saveSeat(seat2);
					return reassignSeatAndEmail(seat);
				}
			}
			return reassignSeatAndEmail(seat);
		} else if (ticket != null && seat != null) {
			if(seat.getTicket().getTicketId() == ticket.getTicketId()){
				return reassignSeatAndEmail(seat);
			} else if(seat.getTicket() == null){
				seat.setTicket(ticket);
				return reassignSeatAndEmail(seat);
			} else {
				return new ResponseEntity<>(seat, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(seat, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<Seat> reassignSeatAndEmail(Seat seat) {
		return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/isAdmin/{token}")
	public ResponseEntity<Boolean> isAdmin(@PathVariable(value = "token") Integer token) {
		if(token == emp.getToken()){
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
}
