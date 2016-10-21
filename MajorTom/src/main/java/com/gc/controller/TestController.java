package com.gc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.model.Seat;
import com.gc.service.DataService;
import com.gc.service.MailManager;

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
//		System.out.println("Creating Tickets");
//		dataService.saveTicket(new Ticket("Atlas", "May", "atlasm@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(3)));
//		dataService.saveTicket(new Ticket("Mitzy", "May", "mitzym@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(3)));
//		dataService.saveTicket(new Ticket("Viktor", "Vasko", "viktorv@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Mordecai", "Heller", "mheller@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(2)));
//		dataService.saveTicket(new Ticket("Wick", "Sable", "wicks@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(2)));
//		dataService.saveTicket(new Ticket("Ivy", "Pepper", "ipepper@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Rocky", "Rickaby", "rockyr@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Calvin", "McMurray", "freckle@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Edmund", "Church", "echurch@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(2)));
//		dataService.saveTicket(new Ticket("Lacy", "Hardt", "lhardt@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Dorian", "Zibowski", "zib@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(2)));
//		dataService.saveTicket(new Ticket("Nina", "McMurray", "nmcmurray@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Horatio", "Bruno", "hbruno@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Alex", "Kehoe", "captainkehoe@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Dominic", "Drago", "ddrago@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(3)));
//		dataService.saveTicket(new Ticket("Avril", "Froth", "avrilf@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Avery", "Froth", "averyf@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Emery", "Froth", "emeryf@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Benjy", "Froth", "benjyf@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Emily", "Bapka", "mrsbapka@lackadaisy.com",
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Virgil", "Grey", "virgil@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Nicodeme", "Savoy", "nics@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Serafine", "Savoy", "serasavoy@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Asa", "Sweet", "asweet@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(2)));
//		dataService.saveTicket(new Ticket("Elsa", "Arbogast", "elsaa@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Abelard", "Arbogast", "abelarda@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		dataService.saveTicket(new Ticket("Bobby", "Arbogast", "bobbya@lackadaisy.com", 
//				"(314) 555-5555", dataService.findFlightById(1402), dataService.findSeatTypeById(1)));
//		System.out.println("Finished Creating Tickets");
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

//	@RequestMapping(value = "sendFakeMail")
//	public void sendMail() {
//		// Create the application context
//		//ApplicationContext context = new ClassPathXmlApplicationContext("mail-beans.xml");
//
//		// Get the mailer instance
//		//MailManager mailer = (MailManager) context.getBean("mailService");
//
//		// Send a composed mail
//		mailer.sendMail("kyle.garner15@yahoo.com", "Test Subject", "Testing body");
//
//		// Send a pre-configured mail
//		//mailer.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
//	}
}
