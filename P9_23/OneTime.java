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
		Temp.set(Calendar.YEAR, year);
		Temp.set(Calendar.MONTH, month);
		Temp.set(Calendar.DATE, day);
		return Temp.compareTo(AppCalendar) - 1 == 0; //occurs that day
	}
	
	/**
	 * Used to print useful information to text file
	 * @return
	 */
	@Override
	public String getOutput() {
		return "app" + "_" + super.getDate() + "_" + getDescription();
	}
	
	public void parseString(String stringToParse) {
		////TODO
	}
}
