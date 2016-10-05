package com.gc.service;

import com.gc.model.Airline;
import com.gc.model.Destination;
import com.gc.model.Employee;
import com.gc.model.Flight;
import com.gc.model.Seat;
import com.gc.model.SeatType;
import com.gc.model.Ticket;


public interface DataService {
	void saveAirline(Airline airline);
	void saveDestination(Destination destination);
	void saveEmployee(Employee employee);
	void saveFlight(Flight flight);
	void saveSeat(Seat seat);
	void saveSeatType(SeatType seatType);
	void saveTicket(Ticket ticket);
	
	void findAllAirlines();
	void findAllDestinations();
	void findAllEmployees();
	void findAllFlights();
	void findAllSeats();
	void findAllSeatTypes();
	void findAllTickets();
	
	Airline findAirlineById(Integer id);
	Destination findDestinationById(Integer id);
	Employee findEmployeeById(Integer id);
	Flight findFlightById(Integer id);
	Seat findSeatById(Integer id);
	SeatType findSeatTypeById(Integer id);
	Ticket findTicketById(Integer id);
	
	Airline findAirlineByName(String name);
	Ticket findTicketBySeat(Seat seat);
}
