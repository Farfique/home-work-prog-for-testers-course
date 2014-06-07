package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBaseClass {

	enum months {January, February, Match, April, May, June, July, September, October, November, December};
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
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[] {group});
		}
		return list.iterator();
	}
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {
			ContactData contact = new ContactData();
			contact.contactName = generateRandomString();
			contact.lastName = generateRandomString();
			contact.firstAddress = generateRandomString();
			contact.firstHomePhone = generateRandomString();
			contact.mobilePhone = generateRandomString();
			contact.workPhone = generateRandomString();
			contact.email = generateRandomString();
			contact.secondEmail = generateRandomString();
			contact.day = generateRandomDay();
			contact.month = generateRandomMonth();
			contact.year = generateRandomYear();
			contact.secondAddress = generateRandomString();
			contact.secondHomePhone = generateRandomString();	
			
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

public <T> int generateRandomIndex(List<T> list){
	Random rnd = new Random();
	int index = 0;
	if (list.size() >= 1){
		index = rnd.nextInt(list.size()-1);
	}
	else
		index = -1;
	return index;
	}

public <T> int generateRandomQuantity(List<T> list){
	int qty;
	qty = generateRandomIndex(list)+1;
	return qty;
	}

public boolean isIndexTheSame(int[] index, int item){
	boolean same = false;
	for (int j = 0; j<item; j++){
		if (index[item]== index[j]){
			same = true;
		}	
	}
	return same;
	}

}
