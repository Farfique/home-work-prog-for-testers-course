package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBaseClass {
	
	@Test
	public void testDeleteContact() throws Exception{
		app.getNavigationHelper().goToHomePage();
	    //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    //actions
	    int index = 3;
		app.getContactHelper().initEditContact(index);
		app.getContactHelper().deleteContact();
	    app.getContactHelper().returnHomeFromNewContact();
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare two states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}

}
