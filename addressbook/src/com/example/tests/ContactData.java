package com.example.tests;

public class ContactData {
	public String contactName;
	public String lastName;
	public String firstAddress;
	public String firstHomePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String secondEmail;
	public String day;
	public String month;
	public String year;
	public String secondAddress;
	public String secondHomePhone;
	
	public ContactData() {
	}
	
	public ContactData(String contactName, String lastName,
			String firstAddress, String firstHomePhone, String mobilePhone,
			String workPhone, String email, String secondEmail,
			String day, String month, String year, String secondAddress,
			String secondHomePhone) {
		this.contactName = contactName;
		this.lastName = lastName;
		this.firstAddress = firstAddress;
		this.firstHomePhone = firstHomePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.secondEmail = secondEmail;
		this.day = day;
		this.month = month;
		this.year = year;
		this.secondAddress = secondAddress;
		this.secondHomePhone = secondHomePhone;
	}
}