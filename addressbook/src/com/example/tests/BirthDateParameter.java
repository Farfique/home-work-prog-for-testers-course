package com.example.tests;

public class BirthDateParameter {
	public String _day;
	public String _month;
	public String _year;

	public BirthDateParameter() {
		this._day = "1";
		this._month = "January";
		this._year = "2000";
	}
	public BirthDateParameter(String _day, String _month, String _year) {
		this._day = _day;
		this._month = _month;
		this._year = _year;
	}
}