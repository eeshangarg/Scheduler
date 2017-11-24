package Scheduler;

public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY;
	    
	    @Override
	    public String toString() {
	      switch(this) {
	        case SUNDAY: return "Sunday";
	        case MONDAY: return "Monday";
	        case TUESDAY: return "Tuesday";
	        case WEDNESDAY: return "Wednesday";
	        case THURSDAY: return "Thursday";
	        case FRIDAY: return "Friday";
	        case SATURDAY: return "Saturday";
	        default: throw new IllegalArgumentException();
	      }
	    }
	     
	     public static Day getDayEnum(String sday) {
	    	switch(sday) {
	    	case "Sunday": return Day.SUNDAY;
	    	case "Monday": return Day.MONDAY;
	    	case "Tuesday": return Day.TUESDAY;
	    	case "Wednesday": return Day.WEDNESDAY;
	    	case "Thursday": return Day.THURSDAY;
	    	case "Friday": return Day.FRIDAY;
	    	case "Saturday": return Day.SATURDAY;
	    	default: throw new IllegalArgumentException();
	    	}
	     }
	    
	}


