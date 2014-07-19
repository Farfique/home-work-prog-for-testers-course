package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	@DataProvider
	public Iterator<Object[]> contactsFromCSVFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}
	@DataProvider
	public Iterator<Object[]> contactsFromXMLFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromXMLFile")
  
  public void testAddNewValidContact(ContactData contactData) throws Exception {
    
    //save old state
    List<ContactData> oldBDList = app.getHibernateHelper().listContacts();
    
    //actions
    app.getContactHelper().createNewContact(contactData);
    
    //save new state
    List<ContactData> newBDList = app.getHibernateHelper().listContacts();
    List<ContactData> newUIList = app.getContactHelper().getUIContacts();
    
    //compare two states
    oldBDList.add(contactData);
    Collections.sort(oldBDList);
    Collections.sort(newBDList);
    Collections.sort(newUIList);
    
    assertEquals(newBDList, oldBDList);
    assertEquals(newBDList, newUIList);
  }
 
  
}