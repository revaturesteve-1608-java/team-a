package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dao.TicketRepo;
import com.gc.model.Ticket;

/**
 * Contains methods, mapped as RESTful services, to query and manipulate the database
 */
@RestController
public class ClientController {
	
	@Autowired
	TicketRepo ticketRepo;
	
	/**
	 * responds to an AngularJS request with either a given ticket (specified by ID) 
	 * and an OK status, or a null object and a NOT FOUND status
	 * A test to see if the ternary operator can be used in a Response Entity!
	 * 
	 * @param Integer the id of the ticket to be found
	 * 
	 * @return ResponseEntity<Ticket> the ticket found by the database, with a status of accepted or not found based on success
	 */
	@RequestMapping("/byId/{ticketId}")
	public ResponseEntity<Ticket> findTicket(@PathVariable(value = "ticketId") Integer ticketId){
		Ticket tick=ticketRepo.findOne(ticketId);
		return new ResponseEntity<>(tick,tick==null?HttpStatus.NOT_FOUND:HttpStatus.ACCEPTED);
	}
}