import java.util.Calendar;

public class DateAndTimeGiver {
	static String dateGiver() {
		Calendar c = Calendar.getInstance();
		String day=String.valueOf(c.get(Calendar.DATE));
		if(day.length()==1)day="0"+day;
		String month=String.valueOf(c.get(Calendar.MONTH)+1);
		if(month.length()==1)month="0"+month;
		String year=String.valueOf(c.get(Calendar.YEAR));
		return day+"-"+month+"-"+year;
	}
}
