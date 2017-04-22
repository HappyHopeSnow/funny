package com.weishu.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * 
 * @author Lee
 * 
 *         2012-4-24 下午1:47:41
 */
public class DateUtils {

	public static final String DATE_FORMAT_MIDDLE = "yyyy-MM-dd";
	public static final String DATE_FORMAT_CHINA = "yyyy年MM月dd日";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String MONTH_FORMAT = "yyyy-MM";
	public static final String MINITUE_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMAT = "yyyyMMdd";

	public static String getDate(Date date) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		String str = dateToString(localCalendar.getTime(), DATE_FORMAT);
		return str;
	}

	public static String getDateWithChina() {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(new Date());
		String str = dateToString(localCalendar.getTime(), DATE_FORMAT_CHINA);
		return str;
	}

	public static String getDate(int paramInt) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(new Date());
		localCalendar.add(Calendar.DATE, paramInt);
		String str = dateToString(localCalendar.getTime(), DATE_FORMAT_MIDDLE);
		return str;
	}

	public static String getDate(int paramInt, String paramString) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(new Date());
		localCalendar.add(Calendar.DATE, paramInt);
		String str = dateToString(localCalendar.getTime(), paramString);
		return str;
	}

	public static int getWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public static String getWeekChina(int week) {
		String result;
		switch (week) {
			case 1:
				result = "星期日";
				break;
			case 2:
				result = "星期一";
				break;
			case 3:
				result = "星期二";
				break;
			case 4:
				result = "星期三";
				break;
			case 5:
				result = "星期四";
				break;
			case 6:
				result = "星期五";
				break;
			case 7:
				result = "星期六";
				break;
			default:
				result = "星期日";
				break;
		}
		return result;
	}

	public static String getWeekChina(Date date) {
		return getWeekChina(getWeek(date));
	}

	public static String dateToString(Date date) {
		return dateToString(date, DATETIME_FORMAT);
	}

	public static String dateToString(Date date, String format) {
		if ((date == null) || (format == null))
			return null;
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
		return localSimpleDateFormat.format(date);
	}
	
	public static String dateToFullString(Date date) {
		String dateStr = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINESE).format(date);
		return dateStr;
	}

	public static Date stringToDate(String dateStr) {
		return stringToDate(dateStr, DATE_FORMAT_MIDDLE);
	}

	public static Date stringToDate(String dateStr, String format) {
		Date localDate = null;
		if ((dateStr != null) && (format != null))
			try {
				SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
				localDate = localSimpleDateFormat.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
				localDate = null;
			}
		return localDate;
	}

	public static String getNowYear() {
		Calendar localCalendar = Calendar.getInstance();
		int i = localCalendar.get(Calendar.YEAR);
		return String.valueOf(i);
	}

	public static String getNowMonth() {
		Calendar localCalendar = Calendar.getInstance();
		int i = localCalendar.get(Calendar.MONTH) + 1;
		if (i < 10)
			return "0" + i;
		return String.valueOf(i);
	}
	
	/**
	 * 是同一天 
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		
		boolean same = calendar.get(Calendar.YEAR)==calendar2.get(Calendar.YEAR)
				&& calendar.get(Calendar.MONTH)==calendar2.get(Calendar.MONTH)
				&& calendar.get(Calendar.DATE)==calendar2.get(Calendar.DATE);
		
		return same;
	}

	public static String getNowDay() {
		return dateToString(new Date(), "dd");
	}

	public static String getYestday() {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.add(Calendar.DATE, -1);
		return dateToString(localCalendar.getTime(), "dd");
	}

	public static Date getDateFront(int paramInt) {
		return new Date(Calendar.getInstance().getTimeInMillis() - 2651224907L * paramInt);
	}

	public static String getNowHour() {
		return dateToString(new Date(), "HH");
	}

	public static String getNowMinute() {
		return dateToString(new Date(), "mm");
	}

	public static Date setDate(String paramString, int paramInt) {
		if (paramString != null) {
			Date localDate = stringToDate(paramString, DATE_FORMAT_MIDDLE);
			return setDate(localDate, paramInt);
		}
		return null;
	}

	public static Date setDate(Date paramDate, int paramInt) {
		Date localDate = null;
		Calendar localCalendar = null;
		if (paramDate != null) {
			localCalendar = Calendar.getInstance();
			localCalendar.setTime(paramDate);
			localCalendar.add(Calendar.DATE, paramInt);
			localDate = localCalendar.getTime();
		}
		return localDate;
	}

	public static int getDayBetween(Date date1, Date date2) {
		Calendar localCalendar1 = Calendar.getInstance();
		Calendar localCalendar2 = Calendar.getInstance();
		if (date1.before(date2)) {
			localCalendar1.setTime(date1);
			localCalendar2.setTime(date2);
		} else {
			localCalendar1.setTime(date2);
			localCalendar2.setTime(date1);
		}
		int sum = 0;
		int startYearDay = localCalendar1.get(Calendar.DAY_OF_YEAR);
		int endYearDay = localCalendar2.get(Calendar.DAY_OF_YEAR);
		int startYear = localCalendar1.get(Calendar.YEAR);
		int endYear = localCalendar2.get(Calendar.YEAR);
		localCalendar1.clear();
		localCalendar1.set(startYear, Calendar.JANUARY, 1);
		while (startYear != endYear) {
			localCalendar1.set(startYear ++, Calendar.DECEMBER, 31);
			sum += localCalendar1.get(Calendar.DAY_OF_YEAR);
		}
		return sum + endYearDay - startYearDay;
	}

	public static Date addDay(Date date, int offset) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		localCalendar.add(Calendar.DATE, offset);
		return localCalendar.getTime();
	}
	
	public static Date addYear(Date date, int offset) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		localCalendar.add(Calendar.YEAR, offset);
		return localCalendar.getTime();
	}
	
	public static Date addMonth(Date date, int offset) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		localCalendar.add(Calendar.MONTH, offset);
		return localCalendar.getTime();
	}
	
	public static Date addWeek(Date date, int offset) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		localCalendar.add(Calendar.WEEK_OF_MONTH, offset);
		return localCalendar.getTime();
	}
	
	public static Date addHour(Date date, int offset) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		localCalendar.add(Calendar.HOUR_OF_DAY, offset);
		return localCalendar.getTime();
	}

	/**
	 * 减几个小时的时间
	 * @return
	 */
	public static Date decHour(Date date, int offset) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		localCalendar.add(Calendar.HOUR_OF_DAY, 0 - offset);
		return localCalendar.getTime();
	}

	/**
	 * 减几分钟的时间
	 * @return
	 */
	public static Date decMinute(Date date, int offset) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(date);
		localCalendar.add(Calendar.MINUTE, 0 - offset);
		return localCalendar.getTime();
	}

	/**
	 * 转成当天的凌晨时间
	 * @param date
	 * @return
	 */
	public static Date toZeroDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	/**
	 * 转成第二天0点
	 * @param date
	 * @return
	 */
	public static Date toNextZeroDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, 1);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	public static Date toZoneDay(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, hour, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}

	/**
	 * 转成当月第一天的凌晨时间
	 * @param date
	 * @return
	 */
	public static Date toZeroMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.set(year, month, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	public static long takeTime(Date oldTime) {
		return takeTime(oldTime, new Date());
	}

	public static long takeTime(Date oldTime, Date newTime) {
		return newTime.getTime() - oldTime.getTime();
	}
	
	public static ContestDate getLastMonth(Date date){
		ContestDate cdate = new ContestDate(date);
		return new ContestDate(new Date(cdate.monthStart.getTime() -1 ));
	}
	public static ContestDate getLastWeek(Date date){
		ContestDate cdate = new ContestDate(date);
		return new ContestDate(new Date(cdate.weekStart.getTime() -1));
	}
	public static ContestDate getCurWeek(Date date){
		return new ContestDate(date);
	}
	public static int getWeekCountByYearMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 15);
		return new ContestDate(calendar.getTime()).weekCount;
	}
	public static class ContestDate {
		public static int ACCOUNT_DAY = Calendar.SATURDAY;
		public static int DAYS_OF_ACCOUNT_CYCLE = 7;
		public static int ACCOUNT_HOUR = 20;
		public static int ACCOUNT_VOTE_HOUR = 0;
		
		public int year;			//--所属年
		public int month;			//--所属月
		public int week;			//--所属月第几周
		public int weekCount;		//--所属月有几周
		public Date date;			//--指定时间原始值
		public Date weekVoteStart;	//--周投票开始时间(当天0点)
		public Date weekStart;		//--周开始时间(当天20点)
		public Date weekEnd;		//--周结束时间(当天20点)
		public Date monthStart;		//--月开始时间(当天20点)
		public Date monthEnd;		//--月结束时间(当天20点)
		private ContestDate(){
		}
		private ContestDate(Date theDate){
			if(theDate == null){
				theDate = new Date();
			}
			this.date = theDate;
			
			Calendar calendar = Calendar.getInstance();

			theDate = DateUtils.toZoneDay(theDate, ACCOUNT_HOUR);
			if(date.before(theDate)){
				calendar.setTime(theDate);
				calendar.add(Calendar.DAY_OF_YEAR, - 1);
				theDate = calendar.getTime();
			}else{
				calendar.setTime(theDate);
			}
			
			calendar.set(Calendar.DAY_OF_WEEK, ACCOUNT_DAY);
			this.weekStart = calendar.getTime();
			if(theDate.before(this.weekStart)){
				this.weekEnd = this.weekStart;
				calendar.add(Calendar.DAY_OF_YEAR, - DAYS_OF_ACCOUNT_CYCLE);
				this.weekStart = calendar.getTime();
			}else{
				calendar.add(Calendar.DAY_OF_YEAR, DAYS_OF_ACCOUNT_CYCLE);
				this.weekEnd = calendar.getTime();
			}
			
			this.weekVoteStart = DateUtils.toZoneDay(this.weekStart, ACCOUNT_VOTE_HOUR);
			
			//得到当周所属年月周
			calendar.setTime(weekStart);
			this.year = calendar.get(Calendar.YEAR);
			this.month = calendar.get(Calendar.MONTH);
			this.week = calendar.get(Calendar.WEEK_OF_MONTH);
			//得到当月开始时间
			calendar.add(Calendar.DAY_OF_YEAR, - DAYS_OF_ACCOUNT_CYCLE * this.week);
			this.monthStart = calendar.getTime();
			//计算当月结束时间
			this.weekCount = this.week;
			this.monthEnd = this.weekEnd;
			calendar.setTime(this.weekEnd);
			while(this.month == calendar.get(Calendar.MONTH)){
				calendar.add(Calendar.DAY_OF_YEAR, DAYS_OF_ACCOUNT_CYCLE);
				this.monthEnd = calendar.getTime();
				this.weekCount ++;
			}
		}
		public boolean isVotableAtThisTime(Date date){
			if(date == null){
				return false;
			}
			if(date.after(weekVoteStart) && date.before(weekEnd)){
				return true;
			}else{
				return false;
			}
		}
//		public String toString(){
//			return "\n" +
//					"year:"+this.year+"\nmonth:"+this.month+"\n" +
//					"week:"+this.week+"\nweekCount:"+this.weekCount+"\n" +
//					"date:"+ DateUtils.dateToString(this.date)+"\nweekStart:"+ DateUtils.dateToString(this.weekStart)+"\nweekEnd:"+ DateUtils.dateToString(this.weekEnd)+"\n" +
//					"weekVoteStart:"+ DateUtils.dateToString(this.weekVoteStart)+"\n" +
//					"monthStart:"+ DateUtils.dateToString(this.monthStart)+"\nmonthEnd:"+ DateUtils.dateToString(this.monthEnd);
//		}

		public static void main(String[] args) {
			Date now = new Date();
			System.out.println(DateUtils.getDate(now));
			System.out.println(DateUtils.getDateWithChina());

			System.out.println(DateUtils.getWeek(now));
			System.out.println(DateUtils.getWeekChina(now));
			System.out.println("****************");
			String[] arr = {"1", "2", "3"};
			String str1=StringUtils.join(arr, ",");
			System.out.println(str1);

		}
	}
}
