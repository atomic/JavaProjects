import java.util.Calendar;
import java.util.Date;


public class Daily extends Appointment{
	//Appointment that occurs daily in a date range
	//Occurs everyday within that range
	private Calendar startingDate;
	private Calendar endingDate;
	
	/**
	 * By default, Daily appointment occurs everyday
	 */
	public Daily(String description){
		super(description);
		startingDate = Calendar.getInstance();
		endingDate = Calendar.getInstance();
		startingDate.set(0, 0, 0);
		endingDate.set(9999, 12, 30);
	}
	
	public Daily( String description,
				int s_Year, int s_Month, int s_Day,
				int e_Year, int e_Month, int e_Day) {
		super(description);
		startingDate = Calendar.getInstance();
		endingDate = Calendar.getInstance();
		startingDate.set(s_Year, s_Month, s_Day);
		endingDate.set(e_Year, e_Month, e_Day);
	}
	
	public boolean occursOn(int year, int month, int day){
		Calendar Temp = Calendar.getInstance();
		Temp.set(year,month,day);

		// see Calendar library for detail
		// compareTo return negative if Temp is before Date
		// compareTo return positive if Temp is after Date
		return Temp.compareTo(startingDate) >= 0 && Temp.compareTo(endingDate) <= 0;
	}
	
}
