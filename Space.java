package Scheduler;

public class Space {
	private String location;
	private Interval time;
	private String semester;
	private User user = null;
	public Space(String l, Interval c, String s) {
		this.location=l;
		this.time=c;
		this.semester=s;
	}
	public boolean isAvailable() {
		return this.user == null;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Interval getTime() {
		return time;
	}
	public void setTime(Interval time) {
		this.time = time;
	}
	public void setUser(User u) { this.user = u; }
	public User getUser() { return this.user; }
	
	public String getSemester() { return this.semester; }
	public void setSemester(String s) { this.semester = s; } 
	
	public String toString() {
		return location + ", " + semester + ", " + time.toString();
	}
}
