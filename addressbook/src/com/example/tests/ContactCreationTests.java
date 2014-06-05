package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBaseClass{
  
  @Test
  public void testAddNewFullContact() throws Exception {
    app.getNavigationHelper().goToHomePage();
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    //actions
    app.getContactHelper().goToNewContactPage();
    ContactData contactData = new ContactData();
    contactData.contactName = "TestName";
    contactData.lastName = "Rabinovich";
    contactData.firstAddress = "Energeticheskaya, 20";
    contactData.firstHomePhone = "22-22-22";
    contactData.mobilePhone = "8-921-222-22-22";
    contactData.workPhone = "33-33-33";
    contactData.email = "test@test.ru";
    contactData.secondEmail = "test2@test.ru";
    contactData.day = "13";
    contactData.month = "September";
    contactData.year = "1987";
    contactData.secondAddress = "Energeticheskaya, 40";
    contactData.secondHomePhone = "322-22-22";
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
  @Test
  public void testAddNewEmptyContact() throws Exception {
    app.getNavigationHelper().goToHomePage();
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    //actions
    app.getContactHelper().goToNewContactPage();
    ContactData contactData = new ContactData();
    contactData.contactName = "";
    contactData.lastName = "";
    contactData.email = "";
    contactData.firstHomePhone = "";
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