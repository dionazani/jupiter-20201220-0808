package com.dionazani.argapura.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
	
	public static Timestamp getCurrentTimestamp() {
		
		 Date date= new Date();
		 long time = date.getTime();
		 Timestamp ts = new Timestamp(time);
		 return ts;
		 
	}
	
	public static long getCurrentTimestampInLong() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
	}
	
	public static Date getDateFromString(String strDate) throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);  
		return date;
	}
	
	public static String getFromTimestamp(Timestamp ts) {
		Date date = new Date();
		date.setTime(ts.getTime());
		String formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date);
		
		return formattedDate;
	}

}
