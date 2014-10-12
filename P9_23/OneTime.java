import java.util.Calendar;


public class OneTime extends Appointment {

	/**
	 * By default, its today
	 * @param newDescription
	 */
	public OneTime(String newDescription){
		super(newDescription);
	}
	
	public OneTime(String newDescription, int year, int month, int day){
		super(newDescription,year,month,day);
	}
	
	@Override
	public String getDate() {
		return "One time appointment on " + super.getDate();
	}

	public boolean occursOn(int year, int month, int day){
		Calendar Temp = Calendar.getInstance();
		Temp.set(year,month,day);
		// Debug 
		System.out.println("compare oneTime occurson : = " + Temp.compareTo(AppCalendar));
		return Temp.compareTo(AppCalendar) == 0; //occurs that day
	}
	
}
