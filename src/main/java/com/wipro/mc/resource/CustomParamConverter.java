package com.wipro.mc.resource;


public class CustomParamConverter {

	@Override
	public String toString() {
		return "my date is: [date=" + date + ", month=" + month + ", year=" + year + "]";
	}
	
	private int date;
	private int month;
	private int year;
	public int getDate() {
		return date;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
