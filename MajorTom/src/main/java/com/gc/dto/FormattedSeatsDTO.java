package com.gc.dto;

import java.util.ArrayList;
import java.util.List;

import com.gc.model.Seat;

/**
 * Data transfer object containing info related to seating configurations
 */
public class FormattedSeatsDTO {
	
	List<List<Seat>> first;
	List<List<Seat>> buisness;
	List<List<Seat>> economy;
	boolean empty = true;
	
	/**
	 * No-args constructor
	 */
	public FormattedSeatsDTO() {
		super();
	}
	
	/**
	 * Constructor with all fields
	 * @param seats A list of seats
	 */
	public FormattedSeatsDTO(List<Seat> seats) {
	
		this.first = new ArrayList<>();
		this.buisness = new ArrayList<>();
		this.economy = new ArrayList<>();
		
		List<Seat> rowFirst = new ArrayList<>();
		List<Seat> rowBuisness = new ArrayList<>();
		List<Seat> rowEconomy = new ArrayList<>();
		
		// Creates the rows of seats
		for (Seat seat : seats) {
			if (seat.getSeatType().getSeatTypeId() == 1) {
				empty = false;
				rowEconomy.add(seat);
				if (rowEconomy.size() == 6){
					this.economy.add(rowEconomy);
					rowEconomy = new ArrayList<>();
				}
			}
			else if (seat.getSeatType().getSeatTypeId() == 2) {
				empty = false;
				rowBuisness.add(seat);
				if (rowBuisness.size() == 6){
					this.buisness.add(rowBuisness);
					rowBuisness = new ArrayList<>();
				}
			}
			else if (seat.getSeatType().getSeatTypeId() == 3) {
				empty = false;
				rowFirst.add(seat);
				if (rowFirst.size() == 4){
					this.first.add(rowFirst);
					rowFirst = new ArrayList<>();
				}
			}
		}
	}
	
	/**
	 * Gets the first class seats
	 * @return The first class seats
	 */
	public List<List<Seat>> getFirst() {
		return first;
	}
	
	/**
	 * Sets the first class seats
	 * @param first The first class seats
	 */
	public void setFirst(List<List<Seat>> first) {
		this.first = first;
	}
	
	/**
	 * Gets the business class seats
	 * @return The business class seats
	 */
	public List<List<Seat>> getBuisness() {
		return buisness;
	}
	
	/**
	 * Sets the business class seats
	 * @param buisness The business class seats
	 */
	public void setBuisness(List<List<Seat>> buisness) {
		this.buisness = buisness;
	}
	
	/**
	 * Gets the economy class seats
	 * @return The economy class seats
	 */
	public List<List<Seat>> getEconomy() {
		return economy;
	}
	
	/**
	 * Sets the economy class seats
	 * @param economy The economy class seats
	 */
	public void setEconomy(List<List<Seat>> economy) {
		this.economy = economy;
	}
	
	/**
	 * Returns if empty
	 * @return If empty
	 */
	public boolean isEmpty(){
		return empty;
	}
	
	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "FormattedSeatsDTO [first=" + first + ", buisness=" + buisness + ", economy=" + economy + "]";
	}
}
