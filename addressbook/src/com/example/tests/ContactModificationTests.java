package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBaseClass {
	
	@Test
	public void testRenameContact() throws Exception {
		app.getNavigationHelper().goToHomePage();
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    //actions
	    int index = 2;
		app.getContactHelper().initEditContact(index);
		ContactData contactData = new ContactData();
	    contactData.contactName = "Bunny";
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare two states
	    oldList.get(index).contactName = contactData.contactName;
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void testContactChangedPhone() throws Exception {
		app.getNavigationHelper().goToHomePage();
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    //actions
	    int index = 20;
		app.getContactHelper().initEditContact(20);
		ContactData contactData = new ContactData();
	    contactData.firstHomePhone = "77777";
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare two states
	    oldList.get(index).firstHomePhone = contactData.firstHomePhone;
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	//@Test
	public void testAddGroupToContact() throws Exception{
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().selectContact(4);
		app.getContactHelper().selectGroupByIndex(3);
		app.getContactHelper().addGroupToContact();
		app.getNavigationHelper().goToAGroupPage();
		
	}
	
	//@Test
	public void testAddGroupToFewContacts() throws Exception{
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().selectContact(1);
		app.getContactHelper().selectContact(2);
		app.getContactHelper().selectContact(3);
		app.getContactHelper().selectGroupByIndex(3);
		app.getContactHelper().addGroupToContact();
		app.getNavigationHelper().goToAGroupPage();
	}
	@Test
	public void testModifyContactViaDetails() throws Exception {
		app.getNavigationHelper().goToHomePage();
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    //actions
	    int index = 3;
		app.getContactHelper().openContactDetails(3);
		app.getContactHelper().modifyContactOnDetails();
		ContactData contactData = new ContactData();
	    contactData.firstHomePhone = "88888";
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare two states
	    oldList.get(index).firstHomePhone = contactData.firstHomePhone;
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	
}
