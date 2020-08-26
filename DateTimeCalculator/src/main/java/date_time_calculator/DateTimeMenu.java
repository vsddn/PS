package date_time_calculator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeMenu {
	private static String response;
	private static DateTimeCalculator dateTimeCalculator;
	
	public static void main(String[] args) throws Exception {
		dateTimeCalculator = new DateTimeCalculator();
		DatesManager dates = new DatesManager();
		Scanner sc= new Scanner(System.in);
		
		response = "y";
		
		do {
			showMenu();
			int inputChoice = sc.nextInt();
			if(inputChoice!=12 && inputChoice!=0 && inputChoice!=11 && inputChoice!=13)
			dates.setFirstDate();
			switch (inputChoice) {
				case 1:
					dates.setSecondDate();
					dateTimeCalculator.addTwoDates(dates.getFirstDate(),dates.getSecondDate(),inputChoice);
					break;
				case 2:
					dates.setSecondDate();
					dateTimeCalculator.subtractTwoDates(dates.getFirstDate(), dates.getSecondDate(),inputChoice);
					break;
				case 3:
					dateTimeCalculator.addNDays(dates.getFirstDate(),inputChoice);
					break;
				case 4:
					dateTimeCalculator.subtractNDays(dates.getFirstDate(),inputChoice);
					break;
				case 5:
					dateTimeCalculator.addNWeeks(dates.getFirstDate(),inputChoice);
					break;
				case 6:
					dateTimeCalculator.subtractNWeeks(dates.getFirstDate(),inputChoice);
					break;
				case 7:
					dateTimeCalculator.addNMonths(dates.getFirstDate(),inputChoice);
					break;
				case 8:
					dateTimeCalculator.subtractNMonths(dates.getFirstDate(),inputChoice);
					break;
				case 9:
					dateTimeCalculator.getDayOfTheDate(dates.getFirstDate(),inputChoice);
					break;	
				case 10:
					dateTimeCalculator.getWeekOfTheDate(dates.getFirstDate(),inputChoice);
					break;	
				case 11:
					System.out.println("Yet to be Added...");
					break;
				case 12:		
					dateTimeCalculator.showCurrentHistory();
					break;
				case 13:
					dateTimeCalculator.showOldHistory();
					break;
				case 0:
					response="n";
					dateTimeCalculator.saveHistory();
					break;
				default:
					System.out.println("Please enter a valid option!");
					break;
		}
		
	}	while(!(response.equals("n")));
}

	public static void showMenu() {
		System.out.println("Please select an option:");
		System.out.println("Input 1 for Addition of two dates");
		System.out.println("Input 2 for Subtraction of two dates");
		System.out.println("Input 3 for Addition of n days to a given date");
		System.out.println("Input 4 for Subtraction of n days to a given date");
		System.out.println("Input 5 for Addition of n weeks to a given date");
		System.out.println("Input 6 for Subtraction of n weeks to a given date");
		System.out.println("Input 7 for Addition of n months to a given date");
		System.out.println("Input 8 for Subtraction of n months to a given date");
		System.out.println("Input 9 for Determining Day for a given date");
		System.out.println("Input 10 for Determining Week for a given date");
		System.out.println("Input 11 for Entering Language phrases");
		System.out.println("Input 12 for current sessioin's history");	
		System.out.println("Input 13 for previous session's history");
		System.out.println("Input 0 to Exit the calculator");
	}
}
