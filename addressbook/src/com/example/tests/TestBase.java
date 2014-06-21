package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	enum months {January, February, March, April, May, June, July, September, October, November, December};
	protected static ApplicationManager app;
	
	

	@BeforeSuite
	public void setUp() throws Exception {
		if (app == null){
		app = new ApplicationManager();	   
		}
	  }
	@AfterSuite
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			list.add(new Object[] {group});
		}
		return list.iterator();
	}
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {
			ContactData contact = new ContactData()
			.withContactName(generateRandomString())
			.withLastName(generateRandomString())
			.withFirstAddress(generateRandomString())
			.withFirstHomePhone(generateRandomString())
			.withMobilePhone(generateRandomString())
			.withWorkPhone(generateRandomString())
			.withEmail(generateRandomString())
			.withSecondEmail(generateRandomString())
			.withBirthDay(generateRandomDay())
			.withBirthMonth(generateRandomMonth())
			.withBirthYear(generateRandomYear())
			.withSecondAddress(generateRandomString())
			.withSecondHomePhone(generateRandomString());
			
			list.add(new Object[] {contact});
		}
		return list.iterator();
	}
public String generateRandomMonth(){
		
		Random rnd = new Random();
		int month = rnd.nextInt(11);
		return months.values()[month].toString();
	}
public String generateRandomDay(){
	Random rnd = new Random();
	String day;
	int temp = rnd.nextInt(31);
	if (temp != 0)
	 day = String.valueOf(temp);
	else
		day = "-";
	return day;
}
public String generateRandomYear(){
	Random rnd = new Random();
	int number = rnd.nextInt(100)+1900;
	return String.valueOf(number);
}
public String generateRandomString(){
		
		Random rnd = new Random();
		if (rnd.nextInt(8)== 0){
			return "";
		}
		else {
			return "test" + rnd.nextInt();
		}
	}





}