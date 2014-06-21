package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBaseClass {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testEditContact(ContactData contactData) throws Exception {
		app.getNavigationHelper().goToHomePage();
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    //actions
	    int index = generateRandomIndex(oldList);
		app.getContactHelper().initEditContact(index);
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	    app.getContactHelper().rebuildContactsCache();
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare two states
	    oldList.get(index).updateContactData(contactData);
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
	@Test (dataProvider = "randomValidContactGenerator")
	public void testModifyContactViaDetails(ContactData contactData) throws Exception {
		app.getNavigationHelper().goToHomePage();
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    //actions
	    int index = generateRandomIndex(oldList);
		app.getContactHelper().openContactDetails(index);
		app.getContactHelper().modifyContactOnDetails();
		
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	    app.getContactHelper().rebuildContactsCache();
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare two states
	    oldList.get(index).updateContactData(contactData);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	
}
