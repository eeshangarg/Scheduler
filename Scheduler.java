package Scheduler;
import java.util.LinkedList;

public class Scheduler {
	private LinkedList<Space> acceptedSpaces = new LinkedList<>();
	private LinkedList<Space> availableSpaces = new LinkedList<>();
	private LinkedList<Booking> pendingBookings = new LinkedList<>();

	public void acceptBooking(Booking booking, Space space) {
		User user = booking.getUser();
		if (space.isAvailable()) {
			this.availableSpaces.remove(space);
		    space.setUser(user);
		    this.acceptedSpaces.add(space);
		    this.pendingBookings.remove(booking);
		    booking.setApproved(space);
		}
	}
	

	public LinkedList<Space> getAcceptedSpaces() {
		return acceptedSpaces;
	}

	public LinkedList<Space> getAvailableSpaces() {
		return availableSpaces;
	}
	
	public void addAvailableSpace(Space space) {
		this.availableSpaces.add(space);
	}
	
	public LinkedList<Booking> getPendingBookings() {
		return pendingBookings;
	}
	
	public void submitBookingForReview(Booking booking) {
		this.pendingBookings.add(booking);
	}
	
	public void cancelBooking(Booking booking) {
		// for now only pending/unapproved bookings are able to
		// be cancelled. TODO allow cancelling accepted bookings
		this.pendingBookings.remove(booking);
	}
}
