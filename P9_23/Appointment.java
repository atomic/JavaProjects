import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Appointment {
	private String description;
	//note: can't extends Calender, too much functions to override for that Abstract class
	public Calendar AppCalendar;
	 // this is to format the date from the Calendar
	// static to make all appointments use the same format
	static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
	
	
	public Appointment(){
		description = "";
		AppCalendar = Calendar.getInstance();
	}

	public Appointment(String newDescription){
		description = newDescription;
		AppCalendar = Calendar.getInstance();
	}
	
	public Appointment(String newDescription, int year, int month, int day){
		this(newDescription);
		AppCalendar.set(year,month,day);
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getDate(){
		return format1.format(AppCalendar.getTime());
	}
	
	public void setDescription(String newDescription){
		description = newDescription;
	}
	
	public void setDate(int year, int month, int day){
		AppCalendar.set(year,month,day);
	}
	
	/**
	 * Used to print useful information to text file
	 * @return
	 */
	public String getOutput() {
		return "app" + "_" + getDate() + "_" + description;
	}
	
	/**
	 * @param year    normal format
	 * @param month   from 1 to 12
	 * @param day	   normal format
	 * @return
	 */
	public boolean occursOn(int year, int month, int day){
		Calendar Temp = Calendar.getInstance();
		Temp.set(year,month, day); 

		return (AppCalendar.get(Calendar.ERA) == Temp.get(Calendar.ERA)
	            && AppCalendar.get(Calendar.YEAR) == Temp.get(Calendar.YEAR) 
	            && AppCalendar.get(Calendar.DAY_OF_YEAR) == Temp.get(Calendar.DAY_OF_YEAR));

//		return AppCalendar.compareTo(Temp) == 0; //doesnt work, they include the minutes
	}
	
	public void parseString(String stringToParse) {
		////TODO
	}
	
}
