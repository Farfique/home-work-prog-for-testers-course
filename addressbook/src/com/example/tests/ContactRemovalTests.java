package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void testDeleteContact() throws Exception{
		
	    //save old state
	    List<ContactData> oldBDList = app.getHibernateHelper().listContacts();
	    
	    //actions
	    int index = app.getContactHelper().generateRandomIndex(oldBDList);
	    app.getContactHelper().deleteContact(index);
		
	    //save new state
	    List<ContactData> newUIList = app.getContactHelper().getUIContacts();
	    List<ContactData> newBDList = app.getHibernateHelper().listContacts();
	    
	    //compare two states
	    Collections.sort(oldBDList);
	    oldBDList.remove(index);
	    Collections.sort(oldBDList);
	    Collections.sort(newBDList);
	    Collections.sort(newUIList);
	    assertEquals(newBDList, oldBDList);
	    assertEquals(newBDList, newUIList);
	}

}
