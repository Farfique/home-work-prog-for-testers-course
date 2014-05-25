package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillContactData(ContactData contactData) {
		//Name
		type(By.name("firstname"),contactData.contactName);
	    //Last name
		type(By.name("lastname"),contactData.lastName);
	    //Home Address
		type(By.name("address"),contactData.firstAddress);
	    //Phones
		type(By.name("home"),contactData.firstHomePhone);
	    type(By.name("mobile"),contactData.mobilePhone);
	    type(By.name("work"),contactData.workPhone);
	    //E-mails
	    type(By.name("email"),contactData.email);
	    type(By.name("email2"),contactData.secondEmail);
	    //Birth date	    
	    select(By.name("bday"), contactData.day);
	    select(By.name("bmonth"), contactData.month);
	    type(By.name("byear"),contactData.year);
	    //Group
	    //select(By.name("new_group"), "group 1");
	    //Alternative contacts
	    type(By.name("address2"),contactData.secondAddress);
	    type(By.name("phone2"),contactData.secondHomePhone);
	}

	public void submitContact() {
		click(By.name("submit"));
	}

	public void goToNewContactPage() {
		click(By.linkText("add new"));
	}

	public void returnHomeFromNewContact() {
		click(By.linkText("home page"));
	}

}