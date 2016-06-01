package cn.fuyoushuo.fengshui.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * @author zhangwuji
 *
 */
public class DateFormatUtils {
	private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	public static SimpleDateFormat getThreadSafeFormat() {
		return THREAD_LOCAL_FORMAT.get();
	}

	
	public static String parseTimestamp(Timestamp date){
		  DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  if(date!=null){
			  return sdf.format(date);
		  }
		  
		  return null;
	}




	// 获得当天0点时间
	public static Date getDayMorning(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.DAY_OF_MONTH,0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得当天24点时间
	public static Date getDayNight(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.DAY_OF_MONTH,0);
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.SECOND, 55);
		cal.set(Calendar.MINUTE, 55);
		cal.set(Calendar.MILLISECOND,0);
		return  cal.getTime();
	}


	// 获得前一天0点时间
	public static Date getLastDayMorning(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得前一天24点时间
	public static Date getLastDayNight(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.SECOND, 55);
		cal.set(Calendar.MINUTE,55);
		cal.set(Calendar.MILLISECOND, 0);
		return  cal.getTime();
	}

	// 获得前一周当天0点时间
	public static Date getLastWeekMorning(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.WEEK_OF_YEAR,-1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得前一周当天24点时间
	public static Date getLastWeekNight(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.WEEK_OF_YEAR,-1);
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.SECOND, 55);
		cal.set(Calendar.MINUTE, 55);
		cal.set(Calendar.MILLISECOND, 0);
		return  cal.getTime();
	}

	//获取上一天的当前时间
	public static Date getLastDay(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		return cal.getTime();
	}

	//获取上一周的当前时间
	public static Date getLastWeekDay(Date day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.add(Calendar.WEEK_OF_YEAR,-1);
		return cal.getTime();
	}
	
	
}
