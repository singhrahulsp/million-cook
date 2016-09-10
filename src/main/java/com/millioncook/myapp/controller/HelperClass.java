package com.millioncook.myapp.controller;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperClass {

	public Date getCurrentTimeStamp() throws Exception {

		String dateStr = "";
		Date d = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2014/08/06 15:59:48
		dateStr = dateFormat.format(date);
		try {
			d = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			throw e;
		}
		return d;
	}
	
	
	public Date getFormattedDate(String strDate) throws Exception{
		Date date = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}
	
	

	public String getEncryptedPassword(String passwordToHash) throws Exception {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (Exception e) {
			throw e;
		}
		System.out.println("md5==" + generatedPassword);
		return generatedPassword;
	}

}
