package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper.WHERE;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testEditContact(ContactData contactData) throws Exception {
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    int index = app.getContactHelper().generateRandomIndex(oldList);
	    app.getContactHelper().modifyContact(contactData, index);
	    
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
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	
	    //actions
	    int index = app.getContactHelper().generateRandomIndex(oldList);
	    int groupIndex = app.getContactHelper().rndGroupIndex(WHERE.HOME);
	    
	    app.getContactHelper().attributeGroupToOneContact(index, groupIndex);
		
		
	}
	
	//@Test
	public void testAddGroupToFewContacts() throws Exception{
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	  //actions
	    int[] index = app.getContactHelper().generateFewIndexes(oldList);
	    int groupIndex = app.getContactHelper().rndGroupIndex(WHERE.HOME);
	    
	    app.getContactHelper().attributeGroupToFewContacts(index, groupIndex);
	    
		
	}
	@Test (dataProvider = "randomValidContactGenerator")
	public void testModifyContactViaDetails(ContactData contactData) throws Exception {
		
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    int index = app.getContactHelper().generateRandomIndex(oldList);
	    app.getContactHelper().modifyContactByDetails(index, contactData);
	    
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare two states
	    oldList.get(index).updateContactData(contactData);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	
}
