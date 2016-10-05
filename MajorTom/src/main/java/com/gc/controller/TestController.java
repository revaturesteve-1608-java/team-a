package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
