package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dto.FormattedSeatsDTO;
import com.gc.service.DataService;

@RestController
public class PlaneController {
	
	@Autowired
	DataService dataService;
	
	/* pulls the list of seats by the given flight ID and returns it as a 
	 * rest response with a 200 HTTP status, unless it's null, 
	 * then returns a null and a not found status code
	 */
	@RequestMapping(value="getFormattedSeats/{flightId}")
	public ResponseEntity<FormattedSeatsDTO> getFormattedFlightSeats(@PathVariable(value = "flightId") int flightId ) {
		FormattedSeatsDTO seats = new FormattedSeatsDTO(dataService.findSeatsByFlight(dataService.findFlightById(flightId)));
		return new ResponseEntity<>(seats, seats.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED);
	}
}
