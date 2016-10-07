package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.Seat;
import com.gc.service.DataService;

@RestController
public class PlaneController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value="")
	public ResponseEntity<List<Seat>> getFormattedFlightSeats() {
		return null;//new ResponseEntity<Ticket>(tick,tick==null?HttpStatus.NOT_FOUND:HttpStatus.ACCEPTED);
	}
}
