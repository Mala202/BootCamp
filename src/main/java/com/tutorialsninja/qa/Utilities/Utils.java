package com.tutorialsninja.qa.Utilities;

import java.sql.Date;

public class Utils {
	
	
	public static String emailWithDateTimeStamp() {
		Date date = new Date(0);
		String emailTimeStamp = date.toString().replace("  ", "_").replace(":", "_");
		return "belioska05" + emailTimeStamp + "@gmail.com";
	}
	public static final int implicit_wait = 10;
	public static final int pageload_timeout = 10;
	public static final int script_timeout = 200;

}
