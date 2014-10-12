import java.text.DateFormatSymbols;
import java.util.Calendar;


public class Daily extends Appointment{
	//Appointment that occurs daily in a date range
	//Occurs everyday within that range
	private Calendar startingDate;
	private Calendar endingDate;
	
	/**
	 * By default, Daily appointment occurs everyday for a year
	 */
	public Daily(String description){
		super(description);
		startingDate = Calendar.getInstance();
		endingDate = Calendar.getInstance();
		endingDate.add(Calendar.YEAR, 1);
	}
	
	/**
	 * 
	 * Constructor with starting date and ending date
	 */
	public Daily( String description,
				int s_Year, int s_Month, int s_Day,
				int e_Year, int e_Month, int e_Day) {
		this(description);
		startingDate.set(s_Year, s_Month, s_Day);
		endingDate.set(e_Year, e_Month, e_Day);
	}

	/**
	 * Constructor with only ending date
	 */
	public Daily( String description,
				int e_Year, int e_Month, int e_Day) {
		super(description);
		startingDate = Calendar.getInstance();
		endingDate = Calendar.getInstance();
		endingDate.set(e_Year, e_Month, e_Day);
	}
	
	@Override
	public String getDate() {
		return "Daily Appointment from " + format1.format(startingDate.getTime()) + " to " + format1.format(endingDate.getTime());
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
