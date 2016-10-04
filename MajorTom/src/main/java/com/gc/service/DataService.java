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
	
	void findAllAirline();
	void findAllDestination();
	void findAllEmployee();
	void findAllFlight();
	void findAllSeat();
	void findAllSeatType();
	void findAllTicket();
}
