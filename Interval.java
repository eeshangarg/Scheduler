package Scheduler;

public class Interval {
	private Day day;
	private String start;
	private String end;
	public Interval(Day d,String s, String e) {
		this.start=s;
		this.day=d;
		this.end=e;	
	}
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String toString() {
		return day.toString() + " " + start + "-" + end;
	}
	

}
