package com.gc.service;

import java.util.List;

import com.gc.model.Airline;
import com.gc.model.Airplane;
import com.gc.model.Destination;
import com.gc.model.Employee;
import com.gc.model.Flight;
import com.gc.model.Seat;
import com.gc.model.SeatType;
import com.gc.model.Ticket;


public interface DataService {
	void saveAirline(Airline airline);
	void saveAirplane(Airplane airplane);
	void saveDestination(Destination destination);
	void saveEmployee(Employee employee);
	void saveFlight(Flight flight);
	void saveSeat(Seat seat);
	void saveSeatType(SeatType seatType);
	void saveTicket(Ticket ticket);
	
	List<Airline> findAllAirlines();
	List<Airplane> findAllAirplanes();
	List<Destination> findAllDestinations();
	List<Employee> findAllEmployees();
	List<Flight> findAllFlights();
	List<Seat> findAllSeats();
	List<SeatType> findAllSeatTypes();
	List<Ticket> findAllTickets();
	
	Airline findAirlineById(Integer id);
	Airplane findAirplaneById(Integer id);
	Destination findDestinationById(Integer id);
	Employee findEmployeeById(Integer id);
	Flight findFlightById(Integer id);
	Seat findSeatById(Integer id);
	SeatType findSeatTypeById(Integer id);
	Ticket findTicketById(Integer id);
	
	Airline findAirlineByName(String name);
	List<Seat> findSeatsByFlight(Flight flight);
	Employee findEmployeeByUsernameAndPassword(String username, String password);
	Airplane findAirplaneByName(String string);
	Seat findSeatByTicket(Ticket tick);
}
