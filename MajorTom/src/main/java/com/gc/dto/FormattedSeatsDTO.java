package com.gc.dto;

import java.util.ArrayList;
import java.util.List;

import com.gc.model.Seat;

public class FormattedSeatsDTO {
	List<List<Seat>> first;
	List<List<Seat>> buisness;
	List<List<Seat>> economy;
	public FormattedSeatsDTO() {
		super();
	}
	public FormattedSeatsDTO(List<Seat> seats) {
	
		this.first = new ArrayList<>();
		this.buisness = new ArrayList<>();
		this.economy = new ArrayList<>();
		
		List<Seat> rowFirst = new ArrayList<>();
		List<Seat> rowBuisness = new ArrayList<>();
		List<Seat> rowEconomy = new ArrayList<>();
		
		for (Seat seat : seats) {
			if (seat.getSeatType().getSeatTypeId() == 1) {
				rowEconomy.add(seat);
				if (rowEconomy.size() == 6){
					this.economy.add(rowEconomy);
					rowEconomy = new ArrayList<>();
				}
			}
			else if (seat.getSeatType().getSeatTypeId() == 2) {
				rowBuisness.add(seat);
				if (rowBuisness.size() == 6){
					this.buisness.add(rowBuisness);
					rowBuisness = new ArrayList<>();
				}
			}
			else if (seat.getSeatType().getSeatTypeId() == 3) {
				rowFirst.add(seat);
				if (rowFirst.size() == 4){
					this.first.add(rowFirst);
					rowFirst = new ArrayList<>();
				}
			}
		}
	}
	
	public List<List<Seat>> getFirst() {
		return first;
	}
	public void setFirst(List<List<Seat>> first) {
		this.first = first;
	}
	public List<List<Seat>> getBuisness() {
		return buisness;
	}
	public void setBuisness(List<List<Seat>> buisness) {
		this.buisness = buisness;
	}
	public List<List<Seat>> getEconomy() {
		return economy;
	}
	public void setEconomy(List<List<Seat>> economy) {
		this.economy = economy;
	}
	@Override
	public String toString() {
		return "FormattedSeatsDTO [first=" + first + ", buisness=" + buisness + ", economy=" + economy + "]";
	}
}
