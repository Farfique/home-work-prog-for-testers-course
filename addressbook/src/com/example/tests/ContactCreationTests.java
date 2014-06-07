package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBaseClass{
  
  @Test(dataProvider = "randomValidContactGenerator")
  
  public void testAddNewValidContact(ContactData contactData) throws Exception {
    app.getNavigationHelper().goToHomePage();
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    //actions
    app.getContactHelper().goToNewContactPage();
    app.getContactHelper().fillContactData(contactData);
    app.getContactHelper().submitContact();
    app.getContactHelper().returnHomeFromNewContact();
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    //compare two states
    oldList.add(contactData);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
 
  
}