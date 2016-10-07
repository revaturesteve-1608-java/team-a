package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.MailManager;
import com.gc.model.Seat;
import com.gc.service.DataService;

@RestController
public class TestController {

	@Autowired
	DataService dataService;
	
	@Autowired
	MailManager mailer;

	@RequestMapping(value = "testSave")
	public String TestSave() {
		System.out.println(dataService.findAirlineByName("Air Estonia"));
		// dataService.saveFlight(new Flight());
		return "/TestPage.html";
	}

	@RequestMapping(value = "testTicket")
	public void testTicket() {
		System.out.println("test the ticket");
		Seat s = dataService.findSeatById(1);
		System.out.println("seat:" + s);
		System.out.println("ticket:" + dataService.findTicketBySeat(s));
	}

	@RequestMapping(value = "testSeats")
	public void testSeats() {
		List<Seat> seats = dataService.findSeatsByFlight(dataService.findFlightById(1));
		if (seats != null) {
			for (Seat s : seats) {
				System.out.println("Seat: " + s);
			}
		}
	}

	@RequestMapping(value = "sendFakeMail")
	public void sendMail() {
		// Create the application context
		//ApplicationContext context = new ClassPathXmlApplicationContext("mail-beans.xml");

		// Get the mailer instance
		//MailManager mailer = (MailManager) context.getBean("mailService");

		// Send a composed mail
		mailer.sendMail("kyle.garner15@yahoo.com", "Test Subject", "Testing body");

		// Send a pre-configured mail
		//mailer.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
	}
}
