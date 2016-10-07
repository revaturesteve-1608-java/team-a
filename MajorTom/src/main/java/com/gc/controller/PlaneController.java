package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="")
	public ResponseEntity<FormattedSeatsDTO> getFormattedFlightSeats(@PathVariable(value = "flightId") int flightId ) {
		
		
		
		return null;//new ResponseEntity<FormattedSeatsDTO>(tick,tick==null?HttpStatus.NOT_FOUND:HttpStatus.ACCEPTED);
	}
}
