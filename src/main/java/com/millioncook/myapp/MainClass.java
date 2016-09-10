package com.millioncook.myapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {
	
	public static void main(String[] args) {
		
		String dateStr = "";
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = new Date();
		dateStr = dateFormat.format(date);
		try {
			System.out.println(dateFormat.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
