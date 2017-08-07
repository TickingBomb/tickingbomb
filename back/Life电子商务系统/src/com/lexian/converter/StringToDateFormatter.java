package com.chinasofti.lexian.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class StringToDateFormatter implements Formatter<Date>{

	private String pattern;
	private SimpleDateFormat sdf;
	
	public StringToDateFormatter(String pattern){
		this.pattern = pattern;
		sdf = new SimpleDateFormat(this.pattern);
	}
	
	
	@Override
	public String print(Date date, Locale locale) {
		String value = sdf.format(date);
		return value;
	}

	@Override
	public Date parse(String time, Locale locale) throws ParseException {
		Date date  = sdf.parse(time);
		return date;
	}
	
}
