package com.gc.dto;

import java.util.ArrayList;
import java.util.List;

import com.gc.model.Seat;
import com.gc.model.Ticket;

public class FormattedSeatsDTO {
	List<Seat> first;
	List<Seat> buisness;
	List<Seat> economy;
	List<Ticket> tickets;
	public FormattedSeatsDTO() {
	}
	public FormattedSeatsDTO(List<Seat> seats, List<Ticket> tickets) {
	
		this.first = new ArrayList<>();
		this.buisness = new ArrayList<>();
		this.economy = new ArrayList<>();
		
		for (Seat seat : seats) {
			if (seat.getSeatType().getSeatTypeId() == 1) {
				this.economy.add(seat);
			}
			else if (seat.getSeatType().getSeatTypeId() == 2) {
				this.buisness.add(seat);
			}
			else if (seat.getSeatType().getSeatTypeId() == 3) {
				this.first.add(seat);
			}
		}
		
		this.tickets = tickets;
	}
	
	public List<Seat> getFirst() {
		return first;
	}
	public void setFirst(List<Seat> first) {
		this.first = first;
	}
	public List<Seat> getBuisness() {
		return buisness;
	}
	public void setBuisness(List<Seat> buisness) {
		this.buisness = buisness;
	}
	public List<Seat> getEconomy() {
		return economy;
	}
	public void setEconomy(List<Seat> economy) {
		this.economy = economy;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	@Override
	public String toString() {
		return "FormattedSeatsDTO [first=" + first + ", buisness=" + buisness + ", economy=" + economy + "]";
	}
}
