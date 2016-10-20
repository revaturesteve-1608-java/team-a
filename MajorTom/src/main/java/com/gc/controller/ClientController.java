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

/**
 * Contains methods, mapped as RESTful services, to query and manipulate the database
 */
@RestController
public class ClientController {

	@Autowired
	DataService dataService;
	
	Employee emp;
	
	/**
	 * responds to an AngularJS request with either a given flight (specified by ID) 
	 * and an OK status, or a null object and a NOT FOUND status
	 * 
	 * @param Integer the id of the flight to be found
	 * 
	 * @return ResponseEntity<Flight> the flight found by the database, with a status of accepted or not found based on success
	 */
	@RequestMapping("/findFlight/{flightId}")
	public ResponseEntity<Flight> findFlightById(@PathVariable(value = "flightId") Integer flightId) {
		Flight newFlightInfo = dataService.findFlightById(flightId);
		if (newFlightInfo != null) {
			return new ResponseEntity<>(newFlightInfo, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(newFlightInfo, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * responds to an AngularJS request with either the list of all flights, 
	 * and an OK status, or a null object and a NOT FOUND status if there are none
	 *
	 * @return ResponseEntity<List<Flight>> the list of flights from the database, with a status of accepted or not found based on success
	 */
	@RequestMapping("/findAllFlights")
	public ResponseEntity<List<Flight>> findAllFlights() {
		List<Flight> list = dataService.findAllFlights();
		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * responds to an AngularJS request with either a given ticket (specified by ID) 
	 * and an OK status, or a null object and a NOT FOUND status
	 * A test to see if the ternary operator can be used in a Response Entity!
	 * 
	 * @param Integer the id of the ticket to be found
	 * 
	 * @return ResponseEntity<Ticket> the ticket found by the database, with a status of accepted or not found based on success
	 */
	@RequestMapping("/findTicket/{ticketId}")
	public ResponseEntity<Ticket> findTicket(@PathVariable(value = "ticketId") Integer ticketId){
		Ticket tick=dataService.findTicketById(ticketId);
		return new ResponseEntity<>(tick,tick==null?HttpStatus.NOT_FOUND:HttpStatus.ACCEPTED);
	}
	
	/**
	 * responds to an AngularJS request with either the ticket found in a given seat
	 * and an OK status, or a null object and a NOT FOUND status if it doesn't have one
	 * 
	 * @param Integer the id of the seat to check
	 * 
	 * @return ResponseEntity<Ticket> the ticket found by the database, with a status of accepted or not found based on success
	 */
	@RequestMapping(value = "/findTicketBySeat/{seatId}")
	public ResponseEntity<Ticket> findTicketBySeat(@PathVariable(value = "seatId") Integer seatId) {
		Ticket ticket = dataService.findSeatById(seatId).getTicket();
		if (ticket != null) {
			return new ResponseEntity<>(ticket, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(ticket, HttpStatus.NOT_FOUND);
		}
	}
	

	/**
	 * responds to an AngularJS request with the list of seats found in a given flight
	 * and an OK status, or a null object and a NOT FOUND status if it doesn't have any
	 * 
	 * @param Integer the id of the flight to check
	 * 
	 * @return ResponseEntity<List<Seat>> the list of seats found by the database, with a status of accepted or not found based on success
	 */
	@RequestMapping(value = "/findSeatsByFlight/{flightId}")
	public ResponseEntity<List<Seat>> findSeatsByFlight(@PathVariable(value = "flightId") Integer flightId) {
		List<Seat> seats = dataService.findSeatsByFlight(dataService.findFlightById(flightId));
		if (seats != null) {
			return new ResponseEntity<>(seats, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(seats, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * responds to an AngularJS request with the list of seats found in a given flight
	 * and an OK status, or a null object and a NOT FOUND status if it doesn't have any
	 * 
	 * @param Model the login token passed back
	 * @param AuthenticationDTO the data to check for authentication
	 * 
	 * @return ResponseEntity<Employee> employee with login token to use, with a status of accepted or forbidden based on success
	 */
	@RequestMapping(value="/authenticate")
	public ResponseEntity<Employee> authenticate(Model model, @RequestBody AuthenticationDTO data) {
		emp = dataService.findEmployeeByUsernameAndPassword(data.getUsername(), data.getPassword());
		if(emp != null) {
			// If we have a valid login, give him/her a random authentication token 
			int token = (int) (Math.random()*100000);
			emp.setToken(token);
			return new ResponseEntity<>(emp, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(emp, HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * takes the AngularJS request and sets the given ticket to the given seat in the database
	 *
	 * @param SetSeatDTO the data with the seat and ticket to pair up
	 * 
	 * @return ResponseEntity<Seat> the seat with attached ticket, with a status of accepted or bad request based on success
	 */
	@RequestMapping(value="/setSeat")
	public ResponseEntity<Seat> setSeat(@RequestBody SetSeatDTO data) {
		Ticket ticket = dataService.findTicketById(data.getTicketId());
		Seat seat = dataService.findSeatById(data.getSeatId());
		if (ticket != null && seat != null) {
			if (!seat.getSeatType().getSeatTypeName().equals(ticket.getSeatType().getSeatTypeName()) || seat.getTicket() != null) {
				// Either that seat type was different than what the customer purchased
				// or that seat already had a ticket
				return new ResponseEntity<>(seat, HttpStatus.BAD_REQUEST);
			} else {
				// If, for any reason, there are more seats containing this ticket, set them to null
				// As it is not possible for one ticket to belong to multiple seats
				dataService.setTicketNullWhereTicketIdEquals(ticket.getTicketId());
				
				// Set ticket for the selected seat
				seat.setTicket(ticket);
				dataService.saveSeat(seat);
				return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
			}
		} else {
			return new ResponseEntity<>(seat, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * takes the AngularJS request and switches the two given seats in the database
	 * 
	 * @param Model the data to update the page with so the results of the switch can be shown 
	 * without a page refresh
	 * @param ReassignSeatDTO the data with the two seats to switch
	 * 
	 * @return ResponseEntity<Seat> the new state of the first seat selected, with a status of accepted or bad request based on success
	 */
	@RequestMapping(value="/reassignSeat")
	public ResponseEntity<Seat> reassignSeat(Model model, @RequestBody ReassignSeatDTO data) {
		Ticket ticket = dataService.findTicketById(data.getTicketId());
		Seat seat = dataService.findSeatById(data.getSeatId());
		Seat seat2 = dataService.findSeatById(data.getSeat2Id());
		
		// If ticket is null and tokens match
		if (ticket == null && data.getLoginToken() == emp.getToken()) {
			if(seat != null) {
				if(seat2 != null) {
					// Neither seat was null; swap the 2 seats
					Ticket tempTicket = seat.getTicket();
					seat.setTicket(seat2.getTicket());
					seat2.setTicket(tempTicket);
					dataService.saveSeat(seat);
					dataService.saveSeat(seat2);
					return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
				} else {
					// Seat 2 was null
					seat.setTicket(null);
					dataService.saveSeat(seat);
					dataService.saveSeat(seat2);
					return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
				}
			} else {
				if(seat2.getTicket() != null) {
					// Seat 2's ticket was null
					seat2.setTicket(null);
					dataService.saveSeat(seat);
					dataService.saveSeat(seat2);
					return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
				}
			}
			
			// Return
			return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
			
		} else if (ticket != null && seat != null) {
			if(seat.getTicket().getTicketId() == ticket.getTicketId()) {
				return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
			} else if(seat.getTicket() == null) {
				seat.setTicket(ticket);
				return new ResponseEntity<>(seat, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(seat, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(seat, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * responds to an AngularJS request with whether or not the given user is logged in as an admin
	 * 
	 * @param Integer the employee login token to be checked
	 * 
	 * @return ResponseEntity<Boolean> whether or not the user is an admin, with a status of accepted or bad request based on success
	 */
	@RequestMapping(value="/isAdmin/{token}")
	public ResponseEntity<Boolean> isAdmin(@PathVariable(value = "token") Integer token) {
		// If there is a matching token, this user is logged in as an employee ("admin")
		if(token == emp.getToken()){
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
}
