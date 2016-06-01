//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.fuyoushuo.fengshui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    private static final String SIMPLEFORMAT = "yyyy-MM-dd HH:mm:ss";

    private String version;

    public DateUtils() {
    }

    public static Date addYears(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, number);
        return calendar.getTime();
    }

    public static Date addMonths(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, number);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, number);
        return calendar.getTime();
    }

    public static Date addHours(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(10, number);
        return calendar.getTime();
    }

    public static Date addMinutes(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, number);
        return calendar.getTime();
    }

    public static Date setHms(Date date, Integer hour, Integer minute, Integer second, Integer millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(hour != null) {
            calendar.set(10, hour.intValue());
        }

        if(minute != null) {
            calendar.set(12, minute.intValue());
        }

        if(second != null) {
            calendar.set(13, second.intValue());
        }

        if(millisecond != null) {
            calendar.set(14, millisecond.intValue());
        }

        return calendar.getTime();
    }

    public static Integer getDaysNumbOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return Integer.valueOf(calendar.getActualMaximum(5));
    }

    public static void main(String[] args) {
        System.out.println(116);
    }

    public static String format(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        try {
            return formatter.format(date);
        } catch (Exception var4) {
            return "";
        }
    }

    public static Date parse(String dateStr, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        try {
            return formatter.parse(dateStr);
        } catch (Exception var4) {
            return null;
        }
    }

    public static String getLastYear(String currentTime) {
        Date startTime = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            startTime = formatter.parse(currentTime);
        } catch (ParseException var4) {
            ;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(1, -1);
        startTime = calendar.getTime();
        currentTime = formatter.format(startTime);
        return currentTime;
    }

    public static String getLastMonth(String currentTime) {
        Date startTime = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            startTime = formatter.parse(currentTime);
        } catch (ParseException var4) {
            ;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(2, -1);
        startTime = calendar.getTime();
        currentTime = formatter.format(startTime);
        return currentTime;
    }

    public static String getCurrentMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(2, 0);
        c.set(5, 1);
        String first = format.format(c.getTime());
        return first;
    }

    public static String getCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.get(3);
        return String.valueOf(calendar.get(1)).concat(String.valueOf(calendar.get(3)));
    }

    public static int diffdates(Date date1, Date date2) {
        if(date1 != null && date2 != null) {
            boolean result = false;
            GregorianCalendar gc1 = new GregorianCalendar();
            GregorianCalendar gc2 = new GregorianCalendar();
            gc1.setTime(date1);
            gc2.setTime(date2);
            int result1 = getDays(gc1, gc2);
            return result1;
        } else {
            return -1;
        }
    }

    public static int getDays(GregorianCalendar g1, GregorianCalendar g2) {
        int elapsed = 0;
        GregorianCalendar gc1;
        GregorianCalendar gc2;
        if(g2.after(g1)) {
            gc2 = (GregorianCalendar)g2.clone();
            gc1 = (GregorianCalendar)g1.clone();
        } else {
            gc2 = (GregorianCalendar)g1.clone();
            gc1 = (GregorianCalendar)g2.clone();
        }

        gc1.set(14, 0);
        gc1.set(13, 0);
        gc1.set(12, 0);
        gc1.set(11, 0);
        gc2.set(14, 0);
        gc2.set(13, 0);
        gc2.set(12, 0);
        gc2.set(11, 0);

        while(gc1.before(gc2)) {
            gc1.add(5, 1);
            ++elapsed;
        }

        return elapsed;
    }

    public String getVersion(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Date date = new Date();
        String time = format.format(date);
        return time;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
