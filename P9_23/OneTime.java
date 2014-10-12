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
	
	public boolean occursOn(int year, int month, int day){
		Calendar Temp = Calendar.getInstance();
		Temp.set(year,month,day);
		return Temp.compareTo(AppCalendar) == 0; //occurs that day
	}
	
}
