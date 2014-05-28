package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBaseClass {
	
	@Test
	public void testDeleteContact() throws Exception{
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().initEditContact(3);
		app.getContactHelper().deleteContact();
	    app.getContactHelper().returnHomeFromNewContact();
	}

}
