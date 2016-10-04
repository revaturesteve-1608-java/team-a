package com.gc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gc.dao.AirlineRepo;
import com.gc.dao.DestinationRepo;
import com.gc.dao.EmployeeRepo;
import com.gc.dao.FlightRepo;
import com.gc.dao.SeatRepo;
import com.gc.dao.SeatTypeRepo;
import com.gc.dao.TicketRepo;
import com.gc.model.Airline;
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
	public void findAllAirline() {
		airlineRepo.findAll();
	}
	@Override
	public void findAllDestination() {
		destinationRepo.findAll();
	}
	@Override
	public void findAllEmployee() {
		employeeRepo.findAll();
	}
	@Override
	public void findAllFlight() {
		flightRepo.findAll();
	}
	@Override
	public void findAllSeat() {
		seatRepo.findAll();
	}
	@Override
	public void findAllSeatType() {
		seatTypeRepo.findAll();
	}
	@Override
	public void findAllTicket() {
		ticketRepo.findAll();
	}
}
