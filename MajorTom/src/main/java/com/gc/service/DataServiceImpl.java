package com.gc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gc.dao.AirlineRepo;
import com.gc.dao.AirplaneRepo;
import com.gc.dao.DestinationRepo;
import com.gc.dao.EmployeeRepo;
import com.gc.dao.FlightRepo;
import com.gc.dao.SeatRepo;
import com.gc.dao.SeatTypeRepo;
import com.gc.dao.TicketRepo;
import com.gc.model.Airline;
import com.gc.model.Airplane;
import com.gc.model.Destination;
import com.gc.model.Employee;
import com.gc.model.Flight;
import com.gc.model.Seat;
import com.gc.model.SeatType;
import com.gc.model.Ticket;

@Service
@Transactional
public class DataServiceImpl implements DataService{
	@Autowired
	AirlineRepo airlineRepo;
	@Autowired
	AirplaneRepo airplaneRepo;
	@Autowired
	DestinationRepo destinationRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	SeatRepo seatRepo;
	@Autowired
	SeatTypeRepo seatTypeRepo;
	@Autowired
	TicketRepo ticketRepo;

	/*
	 * Save All methods for every object
	 */
	@Override
	public void saveAirline(Airline airline) {
		airlineRepo.save(airline);
	}
	@Override
	public void saveAirplane(Airplane airplane) {
		airplaneRepo.save(airplane);
	}
	@Override
	public void saveDestination(Destination destination) {
		destinationRepo.save(destination);
	}
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	@Override
	public void saveFlight(Flight flight) {
		flightRepo.save(flight);
	}
	@Override
	public void saveSeat(Seat seat) {
		seatRepo.save(seat);
	}
	@Override
	public void saveSeatType(SeatType seatType) {
		seatTypeRepo.save(seatType);
	}
	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepo.save(ticket);
	}
	
	/*
	 * Find All methods for every object
	 */
	@Override
	public List<Airline> findAllAirlines() {
		return airlineRepo.findAll();
	}
	@Override
	public List<Airplane> findAllAirplanes() {
		return airplaneRepo.findAll();
	}
	@Override
	public List<Destination> findAllDestinations() {
		return destinationRepo.findAll();
	}
	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}
	@Override
	public List<Flight> findAllFlights() {
		return flightRepo.findAll();
	}
	@Override
	public List<Seat> findAllSeats() {
		return seatRepo.findAll();
	}
	@Override
	public List<SeatType> findAllSeatTypes() {
		return seatTypeRepo.findAllOrderBySeatTypeIdAsc();
	}
	@Override
	public List<Ticket> findAllTickets() {
		return ticketRepo.findAll();
	}
	
	/*
	 * Find By Id methods for every object
	 */
	@Override
	public Airline findAirlineById(Integer id) {
		return airlineRepo.findOne(id);
	}
	@Override
	public Airplane findAirplaneById(Integer id) {
		return airplaneRepo.findOne(id);
	}
	@Override
	public Destination findDestinationById(Integer id) {
		return destinationRepo.findOne(id);
	}
	@Override
	public Employee findEmployeeById(Integer id) {
		return employeeRepo.findOne(id);
	}
	@Override
	public Flight findFlightById(Integer id) {
		return flightRepo.findOne(id);
	}
	@Override
	public Seat findSeatById(Integer id) {
		return seatRepo.findOne(id);
	}
	@Override
	public SeatType findSeatTypeById(Integer id) {
		return seatTypeRepo.findOne(id);
	}
	@Override
	public Ticket findTicketById(Integer id) {
		return ticketRepo.findOne(id);
	}
	
	@Override
	public Airline findAirlineByName(String name) {
		return airlineRepo.findByName(name);
	}
	
	@Override
	public Ticket findTicketBySeat(Seat seat) {
		return ticketRepo.findBySeat(seat);
	}
	@Override
	public List<Seat> findSeatsByFlight(Flight flight) {
		return seatRepo.findByFlight(flight);
	}
	@Override
	public Employee findEmployeeByUsernameAndPassword(String username, String password) {
		return employeeRepo.findByUsernameAndPassword(username, password);
	}
}
