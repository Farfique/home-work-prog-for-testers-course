package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void testDeleteContact() throws Exception{
		
	    //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    int index = app.getContactHelper().generateRandomIndex(oldList);
	    app.getContactHelper().deleteContact(index);
		
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare two states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}

}
