package Scheduler;

import java.util.LinkedList;

public class User {
	private String fullName;
	private int studentNumber;
	public User(String n, int num) {
		this.fullName=n;
		this.studentNumber=num;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public void createBooking(LinkedList<Space> spaces, Scheduler scheduler) {
		Booking booking = new Booking(this);
		booking.setSpaces(spaces);
		scheduler.submitBookingForReview(booking);
	}

	public void deleteBooking(Booking booking, Scheduler scheduler) {
		scheduler.cancelBooking(booking);
	}
}
