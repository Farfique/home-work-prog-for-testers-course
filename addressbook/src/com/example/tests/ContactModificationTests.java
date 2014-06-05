package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBaseClass {
	
	@Test
	public void testRenameContact() throws Exception {
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().initEditContact(3);
		ContactData contactData = new ContactData();
	    contactData.contactName = "Renamed";
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	}
	
	@Test
	public void testContactChangedPhone() throws Exception {
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().initEditContact(20);
		ContactData contactData = new ContactData();
	    contactData.firstHomePhone = "123-123-123";
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	}
	@Test
	public void testAddGroupToContact() throws Exception{
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().selectContact(4);
		app.getContactHelper().selectGroupByIndex(3);
		app.getContactHelper().addGroupToContact();
		app.getNavigationHelper().goToAGroupPage();
		
	}
	
	@Test
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
		app.getContactHelper().openContactDetails(3);
		app.getContactHelper().modifyContactOnDetails();
		ContactData contactData = new ContactData();
	    contactData.firstHomePhone = "123-123-123";
	    app.getContactHelper().fillContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getContactHelper().returnHomeFromNewContact();
	}
	
	
}
