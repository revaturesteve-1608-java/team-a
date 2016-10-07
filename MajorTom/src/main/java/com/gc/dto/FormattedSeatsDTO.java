package com.gc.dto;

import java.util.ArrayList;
import java.util.List;

import com.gc.model.Seat;

public class FormattedSeatsDTO {
	List<Seat> first;
	List<Seat> buisness;
	List<Seat> economy;
	public FormattedSeatsDTO() {
	}
	public FormattedSeatsDTO(List<Seat> seats) {
	
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
	
	@Override
	public String toString() {
		return "FormattedSeatsDTO [first=" + first + ", buisness=" + buisness + ", economy=" + economy + "]";
	}
}
