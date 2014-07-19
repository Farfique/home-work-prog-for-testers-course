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
	    List<ContactData> oldUIList = app.getContactHelper().getUIContacts();
	    List<ContactData> oldBDList = app.getHibernateHelper().listContacts();
	    
	    //choose index to modify
	    int index = app.getContactHelper().generateRandomIndex(oldUIList);
	    
	    //define contactData with this index
	    ContactData oldContact = oldUIList.get(index);
	    
	    //find element ID in BD with hope that my sorting is the same as in web, 
	    //and that ID will be unique
	    Collections.sort(oldBDList);
	    String id = oldBDList.get(index).getId();
	    
	    //actions in web ui - contact modification
	    app.getContactHelper().modifyContact(contactData, index);
	    
	    //create clone of the new Contact but in code, it's needed to find element in newUIList
	    ContactData newContact = new ContactData();
	    newContact = contactData;
	    //set to old contact info, if new fields are empty
	    if (newContact.getContactName()==null||newContact.getContactName().isEmpty()){
	    	newContact.setContactName(oldContact.getContactName());
	    }
	    if (newContact.getLastName()==null||newContact.getLastName().isEmpty()){
	    	newContact.setLastName(oldContact.getLastName());
	    }
	    if (newContact.getFirstHomePhone()==null||newContact.getFirstHomePhone().isEmpty()){
	    	newContact.setFirstHomePhone(oldContact.getFirstHomePhone());
	    	if (oldContact.getFirstHomePhone()==null||oldContact.getFirstHomePhone().isEmpty()){
		    	newContact.setFirstHomePhone(newContact.getMobilePhone());
	    	}
	    }
	    if (newContact.getEmail()==null||newContact.getEmail().isEmpty()){
	    	newContact.setEmail(oldContact.getEmail());
	    	if (oldContact.getEmail()==null||oldContact.getEmail().isEmpty()){
		    	newContact.setEmail(newContact.getSecondEmail());
	    	}
	    }
	    //...................
	    
	    //save new state
	    List<ContactData> newUIList = app.getContactHelper().getUIContacts();
	    List<ContactData> newBDList = app.getHibernateHelper().listContacts();
	    
	    //Find created clone in newUIList - find its index
	    int newIndex = 0;
	    try {
	    	newIndex = newUIList.indexOf(newContact);
	    }
	    catch (Throwable ex) {
	    	throw new Exception("Can't find a newly created contact in new list");
	    }
	    
	    //compare two states
	    //oldList.get(index).updateContactData(contactData);
	    //Collections.sort(oldList);
	    //Collections.sort(newList);
	    //assertEquals(newList, oldList);
	    
	    //Create whole modified ContactData - found it by index
	    ContactData modifiedContact = app.getContactHelper().readContactData(newIndex);
	    
	    //Find modified ContactData in BD
	    ContactData newBDContactData = new ContactData();
	    for (ContactData contactData2 : newBDList) {
			if (contactData2.getId().equals(id)) {
				newBDContactData = contactData2;
			}
		}
	    
	    assertEquals(modifiedContact, newBDContactData);
	    
	     
	}
	
	//@Test
	public void testAddGroupToContact() throws Exception{
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getUIContacts();
	
	    //actions
	    int index = app.getContactHelper().generateRandomIndex(oldList);
	    int groupIndex = app.getContactHelper().rndGroupIndex(WHERE.HOME);
	    
	    app.getContactHelper().attributeGroupToOneContact(index, groupIndex);
		
		
	}
	
	//@Test
	public void testAddGroupToFewContacts() throws Exception{
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getUIContacts();
	    
	  //actions
	    int[] index = app.getContactHelper().generateFewIndexes(oldList);
	    int groupIndex = app.getContactHelper().rndGroupIndex(WHERE.HOME);
	    
	    app.getContactHelper().attributeGroupToFewContacts(index, groupIndex);
	    
		
	}
	//@Test (dataProvider = "randomValidContactGenerator")
	public void testModifyContactViaDetails(ContactData contactData) throws Exception {
		
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getUIContacts();
	    
	    //actions
	    int index = app.getContactHelper().generateRandomIndex(oldList);
	    app.getContactHelper().modifyContactByDetails(index, contactData);
	    
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getUIContacts();
	    
	    //compare two states
	    oldList.get(index).updateContactData(contactData);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	
}
