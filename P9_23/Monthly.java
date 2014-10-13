import java.text.DateFormatSymbols;



public class Monthly extends Appointment{
	//Appointment that occurs once a month
	//Occurs on a specific day (Not Date) of the month
	private int startMonth;
	private int endMonth;
	private int dayOfMonth; // use calender? or not?
	
	/**
	 * By default, make it occurs on first day of every month
	 * @param newDescription
	 */
	public Monthly(String newDescription){
		super(newDescription);
		startMonth = 1;
		endMonth = 12;
		dayOfMonth = 1;
	}

	public Monthly(String newDescription, int startMonth, int endMonth, int dayOf) {
		super(newDescription);
		this.startMonth = startMonth;
		this.endMonth = endMonth;
		dayOfMonth = dayOf;
	}
	
	public int getStart(){
		return startMonth;
	}
	
	public int getEnd(){
		return endMonth;
	}
	
	public int getDayOf(){
		return dayOfMonth;
	}
	
	@Override
	public String getDate() {
		return "Monthly Appointment on day " + dayOfMonth + " from " + 
				new DateFormatSymbols().getMonths()[startMonth] + " to " +
				new DateFormatSymbols().getMonths()[endMonth];
	}
	
	public boolean occursOn(int year, int month, int day){
		return 	   month >= this.startMonth
				&& month <= this.endMonth
				&& day   == this.dayOfMonth;
	}
	
	/**
	 * Used to print useful information to text file
	 * @return
	 */
	@Override
	public String getOutput() {
		return "monthly" + "_" + startMonth + ":" + endMonth + ":" + dayOfMonth + "_" + getDescription();
	}

	public void parseString(String stringToParse) {
		////TODO
	}
	
}
