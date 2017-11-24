package Scheduler;

import java.util.LinkedList;

public class Booking {
	private User user;
	private LinkedList<Space> spaces = new LinkedList<>();
	private Space approved = null;
	
	public Booking(User u) {
		this.user = u;
	}
	public Booking() { this.user = null; }
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LinkedList<Space> getSpaces() {
		return spaces;
	}
	public void addSpace(Space space) {
		this.spaces.add(space);
	}
	public void setSpaces(LinkedList<Space> spaces) { this.spaces = spaces; }
	
	public boolean isApproved() {
		return approved != null;
	}
	public void setApproved(Space approved) {
		this.approved = approved;
	}
	public Space getApproved() {
		return this.approved;
	}
	public String toString() {
		return "Booking 1 by Eeshan";
	}
}
