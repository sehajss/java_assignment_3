import java.util.Calendar;
import java.util.Date;

public class DateCalendarExample {
    public static void main(String[] args) {
        // Using Date class
        Date currentDate = new Date();
        System.out.println("Current date and time using Date class: " + currentDate);

        // Using Calendar class
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Month is 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println("Current date and time using Calendar class: "
                + day + "/" + month + "/" + year + " "
                + hour + ":" + minute + ":" + second);
    }
}
