package other;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Обрабатывает данные в виде даты
 */
public class DateEdit {

    /**
     * Обрезает куски входной строки и переводит их в дату типа Calendar
     * @param date Дата в виде строки(dd.mm.yyyy)
     * @return Дата типа Calendar
     */
    public static Calendar stringToDate(String date) {
        int year;
        int month;
        int day;
        day = Integer.parseInt(date.substring(0, 2));
        month = Integer.parseInt(date.substring(3, 5));
        year = Integer.parseInt(date.substring(6, 10));
        Calendar dateRet = new GregorianCalendar();
        dateRet.set(Calendar.YEAR, year);
        dateRet.set(Calendar.MONTH, month - 1);
        dateRet.set(Calendar.DAY_OF_MONTH, day);
        return dateRet;
    }


    /**
     * Форматирует дату с вида "yyyy-Www" в "dd.mm.yyyy"
     * @param date Дата в виде строки(yyyy-Www)
     * @param dayOfWeek День недели в указаной дате
     * @return Дата в виде строки(dd.mm.yyyy)
     */
    public static String formatDate(String date, int dayOfWeek) {
        String month;
        String day;
        int year;
        int week;
        week = Integer.parseInt(date.substring(6, 8));
        year = Integer.parseInt(date.substring(0, 4));
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.WEEK_OF_YEAR, week);
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);

        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
            day = "0" + calendar.get(Calendar.DAY_OF_MONTH);

        } else {
            day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        }

        if ((calendar.get(Calendar.MONTH) + 1) < 10) {
            month = "0" + (calendar.get(Calendar.MONTH) + 1);

        } else {
            month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        }

        date = day + "." + month + "." + year;

        return date;
    }
}
